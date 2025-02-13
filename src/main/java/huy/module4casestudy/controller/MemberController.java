package huy.module4casestudy.controller;


import huy.module4casestudy.configuration.service.IStorageService;
import huy.module4casestudy.model.DTO.MemberUpdateDTO;
import huy.module4casestudy.model.EMemberType;
import huy.module4casestudy.model.Member;
import huy.module4casestudy.model.Player;
import huy.module4casestudy.repository.IMemberRepository;
import huy.module4casestudy.repository.IPlayerRepository;
import huy.module4casestudy.service.member.MemberService;
import huy.module4casestudy.service.player.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private IMemberRepository memberRepository;
    @Autowired
    private IPlayerRepository playerRepository;
    @Autowired
    private IStorageService filesystem;
    @Autowired
    private IPlayerService playerService;

    @GetMapping("")
    public Iterable<Member> getAllMembers() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        return memberService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<?> updateMember(@PathVariable Long id,
                                          @RequestParam(value = "fullName", required = false) String fullName,
                                          @RequestParam(value = "dateOfBirth", required = false) String dateOfBirth,
                                          @RequestParam(value = "nationality", required = false) String nationality,
                                          @RequestParam(value = "hometown", required = false) String hometown,
                                          @RequestParam(value = "memberType", required = false) String memberType,
                                          @RequestParam(value = "height", required = false) BigDecimal height,
                                          @RequestParam(value = "weight", required = false) BigDecimal weight,
                                          @RequestParam(value = "bmi", required = false) BigDecimal bmi,
                                          @RequestParam(value = "ranking", required = false) Integer ranking,
                                          @RequestParam(value = "avatar", required = false) MultipartFile avatar) {

        Optional<Member> optionalMember = memberService.findById(id);
        Member member = optionalMember.orElse(null);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }

        member = optionalMember.get();

        if (fullName != null) member.setFullName(fullName);
        if (nationality != null) member.setNationality(nationality);
        if (hometown != null) member.setHometown(hometown);

        if (dateOfBirth != null && !dateOfBirth.isEmpty()) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                member.setDateOfBirth(LocalDate.parse(dateOfBirth, formatter));
            } catch (DateTimeParseException e) {
                return ResponseEntity.badRequest().body("Ngày sinh không hợp lệ, vui lòng nhập đúng định dạng YYYY-MM-DD.");
            }
        }

        // Nếu là PLAYER, cập nhật thông tin trong Player
        if (member.getMemberType() == EMemberType.PLAYER) {
            Player player = member.getPlayer();
            if (player == null) {
                player = new Player();
                player.setMember(member);
            }
            player.setHeight(height);
            player.setWeight(weight);
            player.setBmi(bmi);
            player.setRanking(ranking);

            playerService.save(player);
            member.setPlayer(player);
        }

        if (avatar != null && !avatar.isEmpty()) {
            filesystem.store(avatar);
            member.setFileName(avatar.getOriginalFilename());
        }

        memberService.save(member);
        return ResponseEntity.ok("Cập nhật thành công!");
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<?> getMemberDetails(@PathVariable Long id) {
        Optional<Member> memberOpt = memberService.findById(id);
        if (!memberOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Member member = memberOpt.get();
        Optional<Player> playerOpt = memberService.findPlayerByMemberId(id);

        Map<String, Object> response = new HashMap<>();
        response.put("id", member.getId());
        response.put("fullName", member.getFullName());
        response.put("dateOfBirth", member.getDateOfBirth());
        response.put("nationality", member.getNationality());
        response.put("hometown", member.getHometown());
        response.put("memberType", member.getMemberType());
        response.put("fileName", member.getFileName()); // Trả về tên file avatar nếu có, null nếu không có

        if (playerOpt.isPresent()) {
            Player player = playerOpt.get();
            response.put("height", player.getHeight());
            response.put("weight", player.getWeight());
            response.put("bmi", player.getBmi());
            response.put("ranking", player.getRanking());
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("")
    public ResponseEntity<?> createMember(@RequestBody MemberUpdateDTO newMemberDTO) {
        // Tạo mới một Member từ DTO
        Member member = new Member();
        member.setFullName(newMemberDTO.getFullName());
        member.setDateOfBirth(newMemberDTO.getDateOfBirth());
        member.setNationality(newMemberDTO.getNationality());
        member.setHometown(newMemberDTO.getHometown());
        member.setMemberType(newMemberDTO.getMemberType());

        // Lưu Member trước
        member = memberRepository.save(member);

        // Nếu là Player, tạo và lưu Player
        if (newMemberDTO.getMemberType() == EMemberType.PLAYER) {
            Player player = new Player();
            player.setId(member.getId()); // Vì dùng @MapsId, ID của Player phải trùng với Member
            player.setMember(member);
            player.setHeight(newMemberDTO.getHeight());
            player.setWeight(newMemberDTO.getWeight());
            player.setBmi(newMemberDTO.getBmi());
            player.setRanking(newMemberDTO.getRanking());

            playerRepository.save(player);
        }

        return ResponseEntity.ok("Thêm mới thành viên thành công!");
    }

}