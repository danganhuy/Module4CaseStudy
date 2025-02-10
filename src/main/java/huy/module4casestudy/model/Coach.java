package huy.module4casestudy.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "coach")
public class Coach {
    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Member member;
}
