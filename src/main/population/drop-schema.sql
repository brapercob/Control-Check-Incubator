
    alter table `administrator` 
       drop 
       foreign key FK_3fec8r1mh0wyk3263uuisrqgc;

    alter table `administrator` 
       drop 
       foreign key FK_2a5vcjo3stlfcwadosjfq49l1;

    alter table `anonymous` 
       drop 
       foreign key FK_dbtwuuiucwxd0d1yhktcxkamj;

    alter table `anonymous` 
       drop 
       foreign key FK_6lnbc6fo3om54vugoh8icg78m;

    alter table `appointment` 
       drop 
       foreign key `FKlipf4217uc7y57b3suqll1d66`;

    alter table `appointment` 
       drop 
       foreign key `FKjdfdy7qb421u3xh85jdrh45aw`;

    alter table `authenticated` 
       drop 
       foreign key FK_c9454l3gwuhevkqx2dsy17sas;

    alter table `authenticated` 
       drop 
       foreign key FK_h52w0f3wjoi68b63wv9vwon57;

    alter table `book_item` 
       drop 
       foreign key `FKdqroshm5h57aasm5vnc9ffh2s`;

    alter table `book_item` 
       drop 
       foreign key `FKhsetrring4b9luho0l7xu1qva`;

    alter table `library` 
       drop 
       foreign key `FKguxmbvqnipm81b84i6fs87tre`;

    alter table `material` 
       drop 
       foreign key `FKfcokotslx7at8hnsadm0qr6nd`;

    alter table `room_booking` 
       drop 
       foreign key `FKjdiw4p3kpddibwc07sguaj2ye`;

    alter table `room_booking` 
       drop 
       foreign key `FKg1j04tl5s8b7suiji8tqmhka3`;

    alter table `room_room_booking` 
       drop 
       foreign key `FK1k1q72dn95sa344f1fg92ppj3`;

    alter table `room_room_booking` 
       drop 
       foreign key `FKoatfc6ayi1sl45d74crm1rd7`;

    alter table `room_teacher` 
       drop 
       foreign key `FKhik1b0ufw3fxuy69scl1mdvw0`;

    alter table `room_teacher` 
       drop 
       foreign key `FK1mtqq2h7x68tsvtiisppqkh3x`;

    alter table `student` 
       drop 
       foreign key FK_d5ujc2da6ll97meye77u0n8l7;

    alter table `student` 
       drop 
       foreign key FK_39b5mf1i5ggh6xowxc8kmf72e;

    alter table `student_subject` 
       drop 
       foreign key `FKl6sohxs09eyxalfpge4isika1`;

    alter table `student_subject` 
       drop 
       foreign key `FK3oip65fbnwpxc4o5uvntna85c`;

    alter table `subject` 
       drop 
       foreign key `FKejdt93h3bkqtvbmntqgwh9pmq`;

    alter table `subject_student` 
       drop 
       foreign key `FKk7j5icy1r0bs1euj5qrc37c6d`;

    alter table `subject_student` 
       drop 
       foreign key `FKhw65fyi3th4dii12e3fsf34mp`;

    alter table `teacher` 
       drop 
       foreign key FK_rskme9swyx4rli055ud3dqqag;

    alter table `teacher` 
       drop 
       foreign key FK_6cgjhg4u98dl7sfkbse4iw9s7;

    alter table `teacher_room_booking` 
       drop 
       foreign key `FKma7rg87lclgmo2rbfb5a9knuj`;

    alter table `teacher_room_booking` 
       drop 
       foreign key `FKsu4bhsga05y1s6v9tqpxen7l6`;

    alter table `visitor` 
       drop 
       foreign key FK_kfysae9aw2ah5oy1x446cysk7;

    alter table `visitor` 
       drop 
       foreign key FK_4h618upfy4548hmjo9yxi33tw;

    alter table `worker` 
       drop 
       foreign key FK_ovmi2o23hknh7hjklolkn0ri9;

    alter table `worker` 
       drop 
       foreign key FK_l5q1f33vs2drypmbdhpdgwfv3;

    drop table if exists `administrator`;

    drop table if exists `anonymous`;

    drop table if exists `appointment`;

    drop table if exists `authenticated`;

    drop table if exists `book`;

    drop table if exists `book_item`;

    drop table if exists `catalog`;

    drop table if exists `library`;

    drop table if exists `material`;

    drop table if exists `room`;

    drop table if exists `room_booking`;

    drop table if exists `room_room_booking`;

    drop table if exists `room_teacher`;

    drop table if exists `stock`;

    drop table if exists `student`;

    drop table if exists `student_subject`;

    drop table if exists `subject`;

    drop table if exists `subject_student`;

    drop table if exists `teacher`;

    drop table if exists `teacher_room_booking`;

    drop table if exists `user_account`;

    drop table if exists `visitor`;

    drop table if exists `worker`;

    drop table if exists `hibernate_sequence`;
