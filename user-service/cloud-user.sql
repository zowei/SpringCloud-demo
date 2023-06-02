/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : cloud-user

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 02/06/2023 17:42:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Kimberly Guzman', '17 North Michigan Ave');
INSERT INTO `user` VALUES (2, 'Duan Lan', '1-1-16 Deshiro, Nishinari Ward');
INSERT INTO `user` VALUES (3, 'Xiang Jiehong', '620 Grape Street');
INSERT INTO `user` VALUES (4, 'Matsui Kaito', '773 Central Avenue');
INSERT INTO `user` VALUES (5, 'Chic Wai Yee', '222 Pollen Street');
INSERT INTO `user` VALUES (6, 'Kwan Chung Yin', '16 1-1715 Sekohigashi, Moriyama Ward');
INSERT INTO `user` VALUES (7, 'Carolyn Kelley', '156 Broadway');
INSERT INTO `user` VALUES (8, 'Koo Chieh Lun', '447 Wicklow Road');
INSERT INTO `user` VALUES (9, 'Nicholas Barnes', '568 Tianbei 1st Rd, Luohu District');
INSERT INTO `user` VALUES (10, 'Cho Lai Yan', '929 Portland St');
INSERT INTO `user` VALUES (11, 'Han Kwok Yin', '620 Papworth Rd, Trumpington');
INSERT INTO `user` VALUES (12, 'Liao Jialun', '13 4-20 Kawagishicho, Mizuho Ward');
INSERT INTO `user` VALUES (13, 'Ray Howard', '2-1-15 Kaminopporo 1 Jo, Atsubetsu Ward');
INSERT INTO `user` VALUES (14, 'Meng Ching Wan', '698 Dong Zhi Men, Dongcheng District');
INSERT INTO `user` VALUES (15, 'Miura Yuna', '934 1st Ave');
INSERT INTO `user` VALUES (16, 'Alan Jackson', '260 Trafalgar Square, Charing Cross');
INSERT INTO `user` VALUES (17, 'Duan Anqi', '1-5-20, Higashi-Shimbashi, Minato-ku');
INSERT INTO `user` VALUES (18, 'Eugene Cruz', '356 Silver St, Newnham');
INSERT INTO `user` VALUES (19, 'Shi Xiaoming', '121 Hanover Street');
INSERT INTO `user` VALUES (20, 'Shi Jialun', '1-5-15, Higashi-Shimbashi, Minato-ku');
INSERT INTO `user` VALUES (21, 'Imai Kasumi', '299 2nd Zhongshan Road, Yuexiu District');
INSERT INTO `user` VALUES (22, 'Wei Zitao', '13-3-15 Toyohira 3 Jo, Toyohira Ward');
INSERT INTO `user` VALUES (23, 'Nishimura Ryota', '574 Stephenson Street');
INSERT INTO `user` VALUES (24, 'Jesus Walker', '532 W Ring Rd, Buji Town, Longgang');
INSERT INTO `user` VALUES (25, 'Florence Brown', '1-7-3 Saidaiji Akodacho');
INSERT INTO `user` VALUES (26, 'Uchida Hikaru', '901 Fifth Avenue');
INSERT INTO `user` VALUES (27, 'Ota Akina', '461 Yueliu Rd, Fangshan District');
INSERT INTO `user` VALUES (28, 'Yuen On Kay', '477 Park End St');
INSERT INTO `user` VALUES (29, 'Steve Baker', '3-27-7 Higashitanabe, Higashisumiyoshi Ward');
INSERT INTO `user` VALUES (30, 'Sugiyama Miu', '69 Rush Street');
INSERT INTO `user` VALUES (31, 'Jennifer Graham', '2-1-12 Kaminopporo 1 Jo, Atsubetsu Ward');
INSERT INTO `user` VALUES (32, 'Kong Shihan', '646 1st Ave');
INSERT INTO `user` VALUES (33, 'Clifford Flores', '422 Lark Street');
INSERT INTO `user` VALUES (34, 'Fu Shihan', '589 Grape Street');
INSERT INTO `user` VALUES (35, 'Fan Shihan', '1-1-12 Deshiro, Nishinari Ward');
INSERT INTO `user` VALUES (36, 'Liao Lik Sun', '2-1-5 Kaminopporo 1 Jo, Atsubetsu Ward');
INSERT INTO `user` VALUES (37, 'Cheng Xiuying', '8 1-1715 Sekohigashi, Moriyama Ward');
INSERT INTO `user` VALUES (38, 'Zheng Zhennan', '516 68 Qinghe Middle St, Haidian District');
INSERT INTO `user` VALUES (39, 'Song Shihan', '944 East Alley');
INSERT INTO `user` VALUES (40, 'Goto Mitsuki', '1-5-12, Higashi-Shimbashi, Minato-ku');
INSERT INTO `user` VALUES (41, 'Yeow Kwok Ming', '178 Regent Street');
INSERT INTO `user` VALUES (42, 'Peng Yuning', '752 Bergen St');
INSERT INTO `user` VALUES (43, 'Kinoshita Eita', '14 1-1715 Sekohigashi, Moriyama Ward');
INSERT INTO `user` VALUES (44, 'Miu Sai Wing', '1-5-6, Higashi-Shimbashi, Minato-ku');
INSERT INTO `user` VALUES (45, 'Yan Zitao', '810 Rush Street');
INSERT INTO `user` VALUES (46, 'Wong Sze Kwan', '256 Redfern St');
INSERT INTO `user` VALUES (47, 'Leroy Lewis', '1-7-16 Omido, Higashiosaka');
INSERT INTO `user` VALUES (48, 'Catherine Thompson', '988 39 William IV St, Charing Cross');
INSERT INTO `user` VALUES (49, 'Lam Hui Mei', '384 Aigburth Rd, Aigburth');
INSERT INTO `user` VALUES (50, 'Shi Zhiyuan', '340 Hongqiao Rd., Xu Hui District');

SET FOREIGN_KEY_CHECKS = 1;
