CREATE TABLE `m_user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `username` varchar(64) DEFAULT NULL,
    `avatar` varchar(255) DEFAULT NULL,
    `email` varchar(64) DEFAULT NULL,
    `password` varchar(64) DEFAULT NULL,
    `status` int(5) DEFAULT NULL,
    `create_date` datetime DEFAULT NULL,
    `last_login` datetime DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `UK_USERNAME` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `m_blog` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `user_id` bigint(20) DEFAULT NULL,
    `title` varchar(255) DEFAULT NULL,
    `description` varchar(255) DEFAULT NULL,
    `content` longtext,
    `create_date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    `update_date` datetime DEFAULT NULL,
    `status` tinyint(4) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;