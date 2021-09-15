-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.34-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table spring_assignment_db.employee_master
CREATE TABLE IF NOT EXISTS `employee_master` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_address` varchar(256) DEFAULT NULL,
  `employee_birthdate` date DEFAULT NULL,
  `employee_city` varchar(500) DEFAULT NULL,
  `employee_first_name` varchar(50) DEFAULT NULL,
  `employee_last_name` varchar(50) DEFAULT NULL,
  `employee_mobile_no` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table spring_assignment_db.employee_master: ~2 rows (approximately)
/*!40000 ALTER TABLE `employee_master` DISABLE KEYS */;
INSERT INTO `employee_master` (`employee_id`, `employee_address`, `employee_birthdate`, `employee_city`, `employee_first_name`, `employee_last_name`, `employee_mobile_no`) VALUES
	(1, 'Pune', '2021-09-15', 'Pune', 'Monika', 'Paygude', '9851020102');
/*!40000 ALTER TABLE `employee_master` ENABLE KEYS */;

-- Dumping structure for table spring_assignment_db.manager_master
CREATE TABLE IF NOT EXISTS `manager_master` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_address` varchar(500) DEFAULT NULL,
  `manager_birthdate` date DEFAULT NULL,
  `manager_company_name` varchar(256) DEFAULT NULL,
  `manager_first_name` varchar(256) DEFAULT NULL,
  `manager_last_name` varchar(256) DEFAULT NULL,
  `manager_mail_address` varchar(256) DEFAULT NULL,
  `manager_password` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table spring_assignment_db.manager_master: ~4 rows (approximately)
/*!40000 ALTER TABLE `manager_master` DISABLE KEYS */;
INSERT INTO `manager_master` (`manager_id`, `manager_address`, `manager_birthdate`, `manager_company_name`, `manager_first_name`, `manager_last_name`, `manager_mail_address`, `manager_password`) VALUES
	(1, 'Pune', '1999-09-24', 'Zplus', 'Prajakta', 'Jagtap', 'prajakta12@gmail.com', '$2a$10$jwpzyuQct0XVg0HJuKjy6OihTCCAWoD1iZhFS7J0StLeQt7zY3SWW');
/*!40000 ALTER TABLE `manager_master` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
