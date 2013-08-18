

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `camera`
-- ----------------------------
DROP TABLE IF EXISTS `camera`;
CREATE TABLE `camera` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `camera_ip` varchar(128) DEFAULT NULL,
  `camera_name` varchar(128) DEFAULT NULL,
  `camera_status` varchar(128) DEFAULT NULL,
  `camera_master` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of camera
-- ----------------------------
INSERT INTO `camera` VALUES ('2', '1', '1', '1', '1', '2013-08-10 22:33:11', '2013-08-10 22:33:11');
INSERT INTO `camera` VALUES ('3', '2', '2', '2', '2', '2013-08-10 22:37:57', '2013-08-10 22:37:57');
INSERT INTO `camera` VALUES ('7', '3', '3', '3', '3', '2013-08-16 16:26:06', '2013-08-16 16:26:06');
INSERT INTO `camera` VALUES ('8', 'z1', '', '12', '122', '2013-08-16 17:23:20', '2013-08-16 17:23:20');
INSERT INTO `camera` VALUES ('9', 'z1', '12', '12', '12', '2013-08-16 17:23:49', '2013-08-16 17:23:49');
INSERT INTO `camera` VALUES ('10', 'z1', '', '12', '12', '2013-08-16 17:25:22', '2013-08-16 17:25:22');

-- ----------------------------
-- Table structure for `system_log`
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `system_time` datetime DEFAULT NULL,
  `server_name` varchar(128) DEFAULT NULL,
  `content` text,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of system_log
-- ----------------------------
INSERT INTO `system_log` VALUES ('1', '2013-08-16 18:26:35', 'servername', 'content', '2013-08-16 18:26:37', '2013-08-16 18:26:37');
INSERT INTO `system_log` VALUES ('2', '2013-08-16 18:26:38', 'servername', 'content', '2013-08-16 18:26:38', '2013-08-16 18:26:38');
INSERT INTO `system_log` VALUES ('3', '2013-08-16 18:26:38', 'servername', 'content', '2013-08-16 18:26:39', '2013-08-16 18:26:39');
INSERT INTO `system_log` VALUES ('4', '2013-08-16 18:26:39', 'servername', 'content', '2013-08-16 18:26:39', '2013-08-16 18:26:39');
INSERT INTO `system_log` VALUES ('5', '2013-08-16 18:26:40', 'servername', 'content', '2013-08-16 18:26:40', '2013-08-16 18:26:40');
INSERT INTO `system_log` VALUES ('6', '2013-08-16 18:26:41', 'servername', 'content', '2013-08-16 18:26:41', '2013-08-16 18:26:41');

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `info` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for `user_camera`
-- ----------------------------
DROP TABLE IF EXISTS `user_camera`;
CREATE TABLE `user_camera` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) DEFAULT NULL,
  `camera_name` varchar(128) DEFAULT NULL,
  `camera_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_camera
-- ----------------------------
INSERT INTO `user_camera` VALUES ('1', 'z1', 'z1', '12', '2013-08-16 20:21:09', '2013-08-16 20:21:09');
INSERT INTO `user_camera` VALUES ('2', '1', '1', '2', '2013-08-16 20:25:38', '2013-08-16 20:25:38');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) DEFAULT NULL,
  `pass_word` varchar(128) DEFAULT NULL,
  `type` int(5) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `read_orignal` int(5) DEFAULT NULL,
  `on_off` int(5) DEFAULT NULL,
  `defog` int(5) DEFAULT NULL,
  `read_defog` int(5) DEFAULT NULL,
  `register_camera` int(5) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'z1', '3B770EBE9B04F171F0EAD0E07D8E2882', '1', '1', '1', '1', '1', '1', '1', '2013-08-10 21:46:03', null);

-- ----------------------------
-- Table structure for `user_log`
-- ----------------------------
DROP TABLE IF EXISTS `user_log`;
CREATE TABLE `user_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_time` datetime DEFAULT NULL,
  `user_name` varchar(128) DEFAULT NULL,
  `content` text,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_log
-- ----------------------------
INSERT INTO `user_log` VALUES ('1', '2013-08-16 19:57:02', 'username', 'content', '2013-08-16 19:57:04', '2013-08-16 19:57:04');
INSERT INTO `user_log` VALUES ('2', '2013-08-16 19:57:05', 'username', 'content', '2013-08-16 19:57:05', '2013-08-16 19:57:05');
INSERT INTO `user_log` VALUES ('3', '2013-08-16 19:57:05', 'username', 'content', '2013-08-16 19:57:05', '2013-08-16 19:57:05');
INSERT INTO `user_log` VALUES ('4', '2013-08-16 19:57:06', 'username', 'content', '2013-08-16 19:57:06', '2013-08-16 19:57:06');
INSERT INTO `user_log` VALUES ('5', '2013-08-16 19:57:07', 'username', 'content', '2013-08-16 19:57:07', '2013-08-16 19:57:07');
INSERT INTO `user_log` VALUES ('6', '2013-08-16 19:57:08', 'username', 'content', '2013-08-16 19:57:08', '2013-08-16 19:57:08');
INSERT INTO `user_log` VALUES ('7', '2013-08-16 19:57:08', 'username', 'content', '2013-08-16 19:57:08', '2013-08-16 19:57:08');
INSERT INTO `user_log` VALUES ('8', '2013-08-16 19:57:09', 'username', 'content', '2013-08-16 19:57:09', '2013-08-16 19:57:09');
