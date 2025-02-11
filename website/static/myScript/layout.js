function createSidebar() {
    let sidebar = document.getElementById("wrapper");
    sidebar.innerHTML = "\n" +
        "            <ul class=\"navbar-nav bg-gradient-primary sidebar sidebar-dark accordion\" id=\"accordionSidebar\">\n" +
        "            \n" +
        "            <!-- Sidebar - Brand -->\n" +
        "            <a class=\"sidebar-brand d-flex align-items-center justify-content-center\" href=\"index.html\">\n" +
        "                <div class=\"sidebar-brand-icon rotate-n-15\">\n" +
        "                    <i class=\"fas fa-laugh-wink\"></i>\n" +
        "                </div>\n" +
        "                <div class=\"sidebar-brand-text mx-3\">SB Admin <sup>2</sup></div>\n" +
        "            </a>\n" +
        "            \n" +
        "            <!-- Divider -->\n" +
        "            <hr class=\"sidebar-divider my-0\">\n" +
        "            \n" +
        "            <!-- Nav Item - Dashboard -->\n" +
        "            <li class=\"nav-item active\">\n" +
        "                <a class=\"nav-link\" href=\"index.html\">\n" +
        "                    <i class=\"fas fa-fw fa-tachometer-alt\"></i>\n" +
        "                    <span>Dashboard</span></a>\n" +
        "            </li>\n" +
        "            \n" +
        "            <!-- Divider -->\n" +
        "            <hr class=\"sidebar-divider\">\n" +
        "            \n" +
        "            <!-- Heading -->\n" +
        "            <div class=\"sidebar-heading\">\n" +
        "                Main\n" +
        "            </div>\n" +
        "            \n" +
        "            <!-- Nav Item - Pages Collapse Menu -->\n" +
        "            <li class=\"nav-item\">\n" +
        "                <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseTwo\"\n" +
        "                   aria-expanded=\"true\" aria-controls=\"collapseTwo\">\n" +
        "                    <i class=\"fas fa-fw fa-table\"></i>\n" +
        "                    <span>Table</span>\n" +
        "                </a>\n" +
        "                <div id=\"collapseTwo\" class=\"collapse\" aria-labelledby=\"headingTwo\" data-parent=\"#accordionSidebar\">\n" +
        "                    <div class=\"bg-white py-2 collapse-inner rounded\">\n" +
        "                        <!--                        <h6 class=\"collapse-header\">Custom Components:</h6>-->\n" +
        "                        <a class=\"collapse-item\" href=\"#\">Coach</a>\n" +
        "                        <a class=\"collapse-item\" href=\"#\">Match</a>\n" +
        "                        <a class=\"collapse-item\" href=\"#\">Member</a>\n" +
        "                        <a class=\"collapse-item\" href=\"#\">Player</a>\n" +
        "                        <a class=\"collapse-item\" href=\"#\">Salary</a>\n" +
        "                        <a class=\"collapse-item\" href=\"#\">Team</a>\n" +
        "                        <a class=\"collapse-item\" href=\"#\">User</a>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </li>\n" +
        "            \n" +
        "            <!-- Divider -->\n" +
        "            <hr class=\"sidebar-divider\">\n" +
        "            \n" +
        "            <!-- Sidebar Toggler (Sidebar) -->\n" +
        "            <div class=\"text-center d-none d-md-inline\">\n" +
        "                <button class=\"rounded-circle border-0\" id=\"sidebarToggle\"></button>\n" +
        "            </div>\n" +
        "        </ul>" + sidebar.innerHTML;
}

function createTopbar() {
    let topbar = document.getElementById("content");
    topbar.innerHTML = "\n" +
        "                    <nav class=\"navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow\">\n" +
        "                    \n" +
        "                        <!-- Sidebar Toggle (Topbar) -->\n" +
        "                        <button id=\"sidebarToggleTop\" class=\"btn btn-link d-md-none rounded-circle mr-3\">\n" +
        "                            <i class=\"fa fa-bars\"></i>\n" +
        "                        </button>\n" +
        "                        \n" +
        "                        <!-- Topbar Navbar -->\n" +
        "                        <ul class=\"navbar-nav ml-auto\">\n" +
        "                            \n" +
        "                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->\n" +
        "                            <li class=\"nav-item dropdown no-arrow d-sm-none\">\n" +
        "                                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"searchDropdown\" role=\"button\"\n" +
        "                                   data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
        "                                    <i class=\"fas fa-search fa-fw\"></i>\n" +
        "                                </a>\n" +
        "                                <!-- Dropdown - Messages -->\n" +
        "                                <div class=\"dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in\"\n" +
        "                                     aria-labelledby=\"searchDropdown\">\n" +
        "                                    <form class=\"form-inline mr-auto w-100 navbar-search\">\n" +
        "                                        <div class=\"input-group\">\n" +
        "                                            <input type=\"text\" class=\"form-control bg-light border-0 small\"\n" +
        "                                                   placeholder=\"Search for...\" aria-label=\"Search\"\n" +
        "                                                   aria-describedby=\"basic-addon2\">\n" +
        "                                            <div class=\"input-group-append\">\n" +
        "                                                <button class=\"btn btn-primary\" type=\"button\">\n" +
        "                                                    <i class=\"fas fa-search fa-sm\"></i>\n" +
        "                                                </button>\n" +
        "                                            </div>\n" +
        "                                        </div>\n" +
        "                                    </form>\n" +
        "                                </div>\n" +
        "                            </li>\n" +
        "                            \n" +
        "                            <!-- Nav Item - User Information -->\n" +
        "                            <li class=\"nav-item dropdown no-arrow\">\n" +
        "                                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"userDropdown\" role=\"button\"\n" +
        "                                   data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
        "                                    <span class=\"mr-2 d-none d-lg-inline text-gray-600 small\">Douglas McGee</span>\n" +
        "                                    <img class=\"img-profile rounded-circle\"\n" +
        "                                         src=\"../static/img/undraw_profile.svg\">\n" +
        "                                </a>\n" +
        "                                <!-- Dropdown - User Information -->\n" +
        "                                <div class=\"dropdown-menu dropdown-menu-right shadow animated--grow-in\"\n" +
        "                                     aria-labelledby=\"userDropdown\">\n" +
        "                                    <a class=\"dropdown-item\" href=\"#\">\n" +
        "                                        <i class=\"fas fa-user fa-sm fa-fw mr-2 text-gray-400\"></i>\n" +
        "                                        Profile\n" +
        "                                    </a>\n" +
        "                                    <a class=\"dropdown-item\" href=\"#\">\n" +
        "                                        <i class=\"fas fa-cogs fa-sm fa-fw mr-2 text-gray-400\"></i>\n" +
        "                                        Settings\n" +
        "                                    </a>\n" +
        "                                    <a class=\"dropdown-item\" href=\"#\">\n" +
        "                                        <i class=\"fas fa-list fa-sm fa-fw mr-2 text-gray-400\"></i>\n" +
        "                                        Activity Log\n" +
        "                                    </a>\n" +
        "                                    <div class=\"dropdown-divider\"></div>\n" +
        "                                    <a class=\"dropdown-item\" href=\"#\" data-toggle=\"modal\" data-target=\"#logoutModal\">\n" +
        "                                        <i class=\"fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400\"></i>\n" +
        "                                        Logout\n" +
        "                                    </a>\n" +
        "                                </div>\n" +
        "                            </li>\n" +
        "                        \n" +
        "                        </ul>\n" +
        "                \n" +
        "                    </nav>" + topbar.innerHTML
}

function createFooter() {
    let footer = document.getElementById("content-wrapper");
    footer.innerHTML += "                <footer class=\"sticky-footer bg-gray-200\">\n" +
        "                    <div class=\"container my-auto\">\n" +
        "                        <div class=\"copyright text-center my-auto\">\n" +
        "                            <span>Copyright &copy; Your Website 2021</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                </footer>"
}

createSidebar();
createTopbar();
createFooter();
