
    create table `administrator` (
       `id` integer not null,
        `version` integer not null,
        `loan_id` integer,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `anonymous` (
       `id` integer not null,
        `version` integer not null,
        `loan_id` integer,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `appointment` (
       `id` integer not null,
        `version` integer not null,
        `date` datetime(6),
        `student_id` integer not null,
        `teacher_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `authenticated` (
       `id` integer not null,
        `version` integer not null,
        `loan_id` integer,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `book` (
       `id` integer not null,
        `version` integer not null,
        `authors` varchar(255),
        `eisbn` varchar(255),
        `genre` varchar(255),
        `isbn` varchar(255),
        `language` varchar(255),
        `number_of_pages` integer,
        `quantity` integer,
        `subject` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `book_item` (
       `id` integer not null,
        `version` integer not null,
        `bar_code` varchar(255),
        `borrowed` datetime(6),
        `format` integer,
        `loan_period` integer,
        `book_id` integer,
        `borrower_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `catalog` (
       `id` integer not null,
        `version` integer not null,
        `date` datetime(6),
        primary key (`id`)
    ) engine=InnoDB;

    create table `library` (
       `id` integer not null,
        `version` integer not null,
        `adress` varchar(255),
        `name` varchar(255),
        `catalog_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `material` (
       `id` integer not null,
        `version` integer not null,
        `description` varchar(255),
        `name` varchar(255),
        `quantity` integer,
        `stock_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `room` (
       `id` integer not null,
        `version` integer not null,
        `capacity` integer,
        `number` integer,
        `room_type` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `room_booking` (
       `id` integer not null,
        `version` integer not null,
        `date` datetime(6),
        `room_id` integer,
        `teacher_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `room_room_booking` (
       `room_id` integer not null,
        `room_bookings_id` integer not null
    ) engine=InnoDB;

    create table `room_teacher` (
       `room_id` integer not null,
        `stuff_id` integer not null
    ) engine=InnoDB;

    create table `stock` (
       `id` integer not null,
        `version` integer not null,
        `date` datetime(6),
        primary key (`id`)
    ) engine=InnoDB;

    create table `student` (
       `id` integer not null,
        `version` integer not null,
        `loan_id` integer,
        `user_account_id` integer,
        `neptun_code` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `student_subject` (
       `student_id` integer not null,
        `subjects_id` integer not null
    ) engine=InnoDB;

    create table `subject` (
       `id` integer not null,
        `version` integer not null,
        `grade` double precision,
        `name` varchar(255),
        `teacher_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `subject_student` (
       `subject_id` integer not null,
        `students_id` integer not null
    ) engine=InnoDB;

    create table `teacher` (
       `id` integer not null,
        `version` integer not null,
        `loan_id` integer,
        `user_account_id` integer,
        `consulting_hours` varchar(255),
        `personal_web` varchar(255),
        `timetable` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `teacher_room_booking` (
       `teacher_id` integer not null,
        `room_bookings_id` integer not null
    ) engine=InnoDB;

    create table `user_account` (
       `id` integer not null,
        `version` integer not null,
        `enabled` bit not null,
        `identity_email` varchar(255),
        `identity_name` varchar(255),
        `identity_surname` varchar(255),
        `password` varchar(255),
        `username` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `visitor` (
       `id` integer not null,
        `version` integer not null,
        `loan_id` integer,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `worker` (
       `id` integer not null,
        `version` integer not null,
        `loan_id` integer,
        `user_account_id` integer,
        `worker_position` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `hibernate_sequence` (
       `next_val` bigint
    ) engine=InnoDB;

    insert into `hibernate_sequence` values ( 1 );

    alter table `room_room_booking` 
       add constraint UK_ojd9um00nemh93shpv763nd9y unique (`room_bookings_id`);

    alter table `room_teacher` 
       add constraint UK_4wgscm9yijw1i4cvxal9gtel4 unique (`stuff_id`);

    alter table `student` 
       add constraint UK_ra180u08m3idhmfcnhyjntujx unique (`neptun_code`);

    alter table `teacher_room_booking` 
       add constraint UK_fmodp76cesfow2svhtqsqpgu9 unique (`room_bookings_id`);

    alter table `user_account` 
       add constraint UK_castjbvpeeus0r8lbpehiu0e4 unique (`username`);

    alter table `administrator` 
       add constraint FK_3fec8r1mh0wyk3263uuisrqgc 
       foreign key (`loan_id`) 
       references `book_item` (`id`);

    alter table `administrator` 
       add constraint FK_2a5vcjo3stlfcwadosjfq49l1 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `anonymous` 
       add constraint FK_dbtwuuiucwxd0d1yhktcxkamj 
       foreign key (`loan_id`) 
       references `book_item` (`id`);

    alter table `anonymous` 
       add constraint FK_6lnbc6fo3om54vugoh8icg78m 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `appointment` 
       add constraint `FKlipf4217uc7y57b3suqll1d66` 
       foreign key (`student_id`) 
       references `student` (`id`);

    alter table `appointment` 
       add constraint `FKjdfdy7qb421u3xh85jdrh45aw` 
       foreign key (`teacher_id`) 
       references `teacher` (`id`);

    alter table `authenticated` 
       add constraint FK_c9454l3gwuhevkqx2dsy17sas 
       foreign key (`loan_id`) 
       references `book_item` (`id`);

    alter table `authenticated` 
       add constraint FK_h52w0f3wjoi68b63wv9vwon57 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `book_item` 
       add constraint `FKdqroshm5h57aasm5vnc9ffh2s` 
       foreign key (`book_id`) 
       references `book` (`id`);

    alter table `book_item` 
       add constraint `FKhsetrring4b9luho0l7xu1qva` 
       foreign key (`borrower_id`) 
       references `user_account` (`id`);

    alter table `library` 
       add constraint `FKguxmbvqnipm81b84i6fs87tre` 
       foreign key (`catalog_id`) 
       references `catalog` (`id`);

    alter table `material` 
       add constraint `FKfcokotslx7at8hnsadm0qr6nd` 
       foreign key (`stock_id`) 
       references `stock` (`id`);

    alter table `room_booking` 
       add constraint `FKjdiw4p3kpddibwc07sguaj2ye` 
       foreign key (`room_id`) 
       references `room` (`id`);

    alter table `room_booking` 
       add constraint `FKg1j04tl5s8b7suiji8tqmhka3` 
       foreign key (`teacher_id`) 
       references `teacher` (`id`);

    alter table `room_room_booking` 
       add constraint `FK1k1q72dn95sa344f1fg92ppj3` 
       foreign key (`room_bookings_id`) 
       references `room_booking` (`id`);

    alter table `room_room_booking` 
       add constraint `FKoatfc6ayi1sl45d74crm1rd7` 
       foreign key (`room_id`) 
       references `room` (`id`);

    alter table `room_teacher` 
       add constraint `FKhik1b0ufw3fxuy69scl1mdvw0` 
       foreign key (`stuff_id`) 
       references `teacher` (`id`);

    alter table `room_teacher` 
       add constraint `FK1mtqq2h7x68tsvtiisppqkh3x` 
       foreign key (`room_id`) 
       references `room` (`id`);

    alter table `student` 
       add constraint FK_d5ujc2da6ll97meye77u0n8l7 
       foreign key (`loan_id`) 
       references `book_item` (`id`);

    alter table `student` 
       add constraint FK_39b5mf1i5ggh6xowxc8kmf72e 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `student_subject` 
       add constraint `FKl6sohxs09eyxalfpge4isika1` 
       foreign key (`subjects_id`) 
       references `subject` (`id`);

    alter table `student_subject` 
       add constraint `FK3oip65fbnwpxc4o5uvntna85c` 
       foreign key (`student_id`) 
       references `student` (`id`);

    alter table `subject` 
       add constraint `FKejdt93h3bkqtvbmntqgwh9pmq` 
       foreign key (`teacher_id`) 
       references `teacher` (`id`);

    alter table `subject_student` 
       add constraint `FKk7j5icy1r0bs1euj5qrc37c6d` 
       foreign key (`students_id`) 
       references `student` (`id`);

    alter table `subject_student` 
       add constraint `FKhw65fyi3th4dii12e3fsf34mp` 
       foreign key (`subject_id`) 
       references `subject` (`id`);

    alter table `teacher` 
       add constraint FK_rskme9swyx4rli055ud3dqqag 
       foreign key (`loan_id`) 
       references `book_item` (`id`);

    alter table `teacher` 
       add constraint FK_6cgjhg4u98dl7sfkbse4iw9s7 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `teacher_room_booking` 
       add constraint `FKma7rg87lclgmo2rbfb5a9knuj` 
       foreign key (`room_bookings_id`) 
       references `room_booking` (`id`);

    alter table `teacher_room_booking` 
       add constraint `FKsu4bhsga05y1s6v9tqpxen7l6` 
       foreign key (`teacher_id`) 
       references `teacher` (`id`);

    alter table `visitor` 
       add constraint FK_kfysae9aw2ah5oy1x446cysk7 
       foreign key (`loan_id`) 
       references `book_item` (`id`);

    alter table `visitor` 
       add constraint FK_4h618upfy4548hmjo9yxi33tw 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `worker` 
       add constraint FK_ovmi2o23hknh7hjklolkn0ri9 
       foreign key (`loan_id`) 
       references `book_item` (`id`);

    alter table `worker` 
       add constraint FK_l5q1f33vs2drypmbdhpdgwfv3 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);
