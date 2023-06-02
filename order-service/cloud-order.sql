/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : cloud-order

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 02/06/2023 17:42:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` decimal(10, 2) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `num` int NULL DEFAULT NULL,
  `userId` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 121 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES (1, 123.00, 'zw', 3, 1);
INSERT INTO `tb_order` VALUES (2, 123.00, 'rcr', 4, 2);
INSERT INTO `tb_order` VALUES (3, 2332.00, 'cds', 5, 3);
INSERT INTO `tb_order` VALUES (4, 312321.00, 'cdc', 6, 4);
INSERT INTO `tb_order` VALUES (5, 1321.00, 'gge', 7, 5);
INSERT INTO `tb_order` VALUES (6, 234.00, 'gty', 8, 3);
INSERT INTO `tb_order` VALUES (7, 234.00, 'gyu', 6, 7);
INSERT INTO `tb_order` VALUES (9, 324.00, 'gji', 7, 8);
INSERT INTO `tb_order` VALUES (10, 456.00, 'dew', 8, 9);

SET FOREIGN_KEY_CHECKS = 1;
