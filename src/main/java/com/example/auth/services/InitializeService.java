package com.example.auth.services;

public class InitializeService {
   /* private final RoleRepository roleRepository;
    private final ApplicationUserRepository userRepository;

    @Value("${security.encoding-strength}")
    private Integer encodingStrength;

    public InitializeService(RoleRepository roleRepository, ApplicationUserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public void initialize() {

        userRepository.deleteAll();
        roleRepository.deleteAll();

        System.out.println("[RoleRepository is empty] : " + roleRepository.findAll().isEmpty());
        System.out.println("[UserRepository is empty] : " + userRepository.findAll().isEmpty());

        if (userRepository.findAll().isEmpty()) {
            SCryptPasswordEncoder encoder = new SCryptPasswordEncoder();
            ApplicationUser user1 = new ApplicationUser("admin", encoder.encode("admin"), new ArrayList<Role>() {{
                add(new Role("admin"));
                add(new Role("sysadmin"));
                add(new Role("user"));
                add(new Role("superuser"));
            }});
            //user1.getRoles().forEach(roleRepository::save);
            ApplicationUser user2 = new ApplicationUser("sysadmin", encoder.encode("qwerty"), new ArrayList<Role>() {{
                add(new Role("admin"));
                add(new Role("sysadmin"));
            }});
            //user2.getRoles().forEach(roleRepository::save);
            ApplicationUser user3 = new ApplicationUser("user", encoder.encode("user1"), new ArrayList<Role>() {{
                add(new Role("user"));
            }});
            //user3.getRoles().forEach(roleRepository::save);
            ApplicationUser user4 = new ApplicationUser("superuser", encoder.encode("superuser123"), new ArrayList<Role>() {{
                add(new Role("admin"));
                add(new Role("superuser"));
            }});
            //user4.getRoles().forEach(roleRepository::save);

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.save(user4);


        }
    }*/
}
