/***************************Role*************************************/
INSERT INTO `Role` (`RoleID`, `Name`, `Description`) 
VALUES 
(1, 'Admin', 'Admin'),
(2, 'HROfficer', '人事主管'),
(3, 'HR', '人事专员'),
(4, 'DepartmentOfficer', '部门主管'),
(5, 'User', '用户');

/**************************User**************************************/
INSERT INTO `User` (`UserID`, `Name`, `Password`, `RegisterDate`, `RoleID`)
VALUES 
(1, 'Admin', '$2a$10$cXH33AnsJinInWRy/i9UIOiTcE1Z47qOwiOQ4x.gX4LQyozOVYj/2', '2014-03-16 16:55:48', 1),
(2, 'HROfficer', '$2a$10$cXH33AnsJinInWRy/i9UIOiTcE1Z47qOwiOQ4x.gX4LQyozOVYj/2', '2014-03-16 16:55:48', 2),
(3, 'HR', '$2a$10$cXH33AnsJinInWRy/i9UIOiTcE1Z47qOwiOQ4x.gX4LQyozOVYj/2', '2014-03-16 16:55:48', 3),
(4, 'lifei', '$2a$10$cXH33AnsJinInWRy/i9UIOiTcE1Z47qOwiOQ4x.gX4LQyozOVYj/2', '2014-03-16 16:55:48', 4),
(5, 'georgeOfficer', '$2a$10$cXH33AnsJinInWRy/i9UIOiTcE1Z47qOwiOQ4x.gX4LQyozOVYj/2', '2014-03-16 16:55:48', 4),
(6, 'ben', '$2a$10$cXH33AnsJinInWRy/i9UIOiTcE1Z47qOwiOQ4x.gX4LQyozOVYj/2', '2014-03-16 16:55:48', 4),
(7, 'George', '$2a$10$cXH33AnsJinInWRy/i9UIOiTcE1Z47qOwiOQ4x.gX4LQyozOVYj/2', '2014-03-16 16:55:48', 5),
(8, 'DepartmentOfficer', '$2a$10$cXH33AnsJinInWRy/i9UIOiTcE1Z47qOwiOQ4x.gX4LQyozOVYj/2', '2014-03-16 16:55:48', 4),
(9, 'George1', '$2a$10$cXH33AnsJinInWRy/i9UIOiTcE1Z47qOwiOQ4x.gX4LQyozOVYj/2', '2014-03-16 16:55:48', 5),
(10, 'George2', '$2a$10$cXH33AnsJinInWRy/i9UIOiTcE1Z47qOwiOQ4x.gX4LQyozOVYj/2', '2014-03-16 16:55:48', 5),
(11, 'George3', '$2a$10$cXH33AnsJinInWRy/i9UIOiTcE1Z47qOwiOQ4x.gX4LQyozOVYj/2', '2014-03-16 16:55:48', 5),
(12, 'George4', '$2a$10$cXH33AnsJinInWRy/i9UIOiTcE1Z47qOwiOQ4x.gX4LQyozOVYj/2', '2014-03-16 16:55:48', 5);

/**************************department********************************/
INSERT INTO `Department` (`DepartmentID`, `Name`, `Type`, `Leader`, `OfficeAddress`, `OfficeTelephone`, `PostalCode`, `PostalAddress`, `Introduction`, `UserID`, `MarkForDelete`)
VALUES 
('1', '研发部', '研发部', 'lifei', '1号楼1楼101室', '13663815937', '450001', '河南省郑州市金水区', '负责研发', '4', false),
('2', '测试部', '测试部', 'george', '1号楼1楼102室', '13663815937', '450001', '河南省郑州市金水区', '负责测试', '5', false),
('3', '市场部', '市场部', 'ben', '1号楼1楼103室', '13663815937', '450001', '河南省郑州市金水区', '负责销售', '6', false);


INSERT INTO `UserInfo` (`UserInfoID`, `RealName`, `CardID`, `Gender`, `Nation`, `Politics`, `Hometown`, `PostalAddress`, `PostalCode`, `Photo`, `PhotoID`, `Marrige`, `Phone`, `ForeignLanguage`, `ComputerLevel`, `UserID`) 
VALUES 
(1, '蒋殷杰', '320483199204087012', '男', '中国', '', '常州 ', '江苏常州新北区', '213127', 'aaaa', '1', 0, '18661137241', '4', '4', '7');

INSERT INTO `Education` (`EducationID`, `Degree`, `GraduationDate`, `Major`, `MajorRanking`, `Academy`, `UserID`, `MarkForDelete`, `Num`)
VALUES
(1, '本科', '2014-03-16', '计算机', '20', '计算机学院', 7, 0, 1);

INSERT INTO `Job` (`JobID`, `Name`) 
VALUES 
(1, 'java程序员'),
(2, '.net程序员'),
(3, '测试人员'),
(4, '推销员'),
(5, '美工人员');

INSERT INTO `JobRecruit` (`JobRecruitID`, `StartTime`, `ExpireTime`, `Person`, `Type`, `DepartmentID`, `MarkForDelete`, `JobID`, `City`, `Approve`) 
VALUES
(1, '2014-03-16 16:55:48', '2014-11-16 16:55:48', '2', '技术类', 1, false, 1, '上海', false),
(2, '2014-03-16 16:55:48', '2014-11-16 16:55:48', '3', '技术类', 1, false, 2, '上海', true),
(3, '2014-03-16 16:55:48', '2014-11-16 16:55:48', '4', '市场类', 1, false, 4, '上海', true),
(4, '2014-03-16 16:55:48', '2014-11-16 16:55:48', '5', '市场类', 1, false, 4, '常州', true),
(5, '2014-03-16 16:55:48', '2014-11-16 16:55:48', '6', '设计类', 1, false, 5, '常州', true),
(6, '2014-03-16 16:55:48', '2014-11-16 16:55:48', '7', '设计类', 1, false, 5, '常州', false),
(7, '2014-03-16 16:55:48', '2014-11-16 16:55:48', '8', '设计类', 1, false, 5, '扬州', true);

INSERT INTO `JobRequire` (`JobRequireID`, `Description`, `JobRecruitID`, `MarkForDelete`, `Num`)
VALUES 
(1, 'ssh', 1, 0, 1),
(2, 'mysql', 1, 0, 2),
(3, 'mysql', 1, 0, 3),
(4, 'mysql', 1, 0, 4),
(5, 'mysql', 1, 0, 5),
(6, 'mysql', 2, 0, 1),
(7, 'c#', 2, 0, 2),
(8, 'sql server', 2, 0, 3),
(9, 'sql server', 2, 0, 4),
(10, 'sql server', 3, 0, 1),
(11, 'sql server', 3, 0, 2),
(12, 'sql server', 3, 0, 3),
(13, 'sql server', 4, 0, 1),
(14, '市场推销', 4, 0, 2),
(15, '市场推销', 4, 0, 3),
(16, '市场推销', 5, 0, 1),
(17, '市场推销', 5, 0, 2),
(18, '市场推销', 5, 0, 3),
(19, '市场推销', 5, 0, 4),
(20, '市场推销', 6, 0, 1),
(21, '对广告了解', 6, 0, 2),
(22, '对广告了解', 6, 0, 3),
(23, '对广告了解', 6, 0, 3),
(24, '对广告了解', 6, 0, 3),
(25, '对广告了解', 7, 0, 1),
(26, '对广告了解', 7, 0, 2),
(27, '对广告了解', 7, 0, 3),
(28, '对广告了解', 7, 0, 4);

INSERT INTO `JobResponsibility` (`JobResponsibilityID`, `Description`, `JobRecruitID`, `MarkForDelete`, `Num`) 
VALUES 
(1, '负责开发', 1, 0, 1),
(2, '负责开发', 1, 0, 2),
(3, '负责开发', 1, 0, 3),
(4, '负责开发', 2, 0, 1),
(5, '负责开发', 2, 0, 2),
(6, '修bug', 2, 0, 3),
(7, '修bug', 2, 0, 4),
(8, '修bug', 2, 0, 5),
(9, '修bug', 3, 0, 1),
(10, '修bug', 3, 0, 2),
(11, '修bug', 3, 0, 3),
(12, '.net负责开发', 3, 0, 1),
(13, '.net负责开发', 3, 0, 2),
(14, '.net负责开发', 3, 0, 3),
(15, '.net负责开发', 3, 0, 4),
(16, '.net负责开发', 3, 0, 5),
(17, '修bug', 4, 0, 1),
(18, '修bug', 4, 0, 2),
(19, '修bug', 4, 0, 3),
(20, '修bug', 5, 0, 1),
(21, '市场推广', 5, 0, 2),
(22, '市场推广', 6, 0, 1),
(23, '市场推广', 6, 0, 2),
(24, '市场推广', 6, 0, 3),
(25, '市场推广', 6, 0, 4),
(26, '广告设计', 7, 0, 1);

INSERT INTO `Status` (`StatusID`, `Name`, `DefaultInfomation`) 
VALUES 
(1, 'New', '用户刚刚申请岗位'),
(2, 'DepartmentApprove', '部门主管审批通过'),
(3, 'DepartmentReject', '部门主管审批未通过'),
(4, 'HRApprove', '人事科员审批通过'),
(5, 'HRReject', '人事科员审批未通过'),
(6, 'HROfficerApprove', '人事领导审批通过'),
(7, 'HROfficerReject', '人事领导审批未通过');

INSERT INTO `JobRequest` (`JobRequestID`, `Remark`, `StatusChangeTime`, `AuditionTime`, `UserID`, `StatusID`, `MarkForDelete`, `JobRecruitID`, `CreateTime`)
VALUES
(1, 'qqq', '2014-03-16 16:55:48', '2014-03-16 16:55:48', 7, 3, 0, 1, '2014-03-16 16:55:48'),
(2, 'qqq1', '2014-03-16 16:55:48', null, 9, 1, 0, 1, '2014-03-16 16:55:48'),
(3, 'qqq2', '2014-03-16 16:55:48', '2014-03-16 16:55:48', 10, 2, 0, 1, '2014-03-16 16:55:48'),
(4, 'qqq3', '2014-03-16 16:55:48', '2014-03-16 16:55:48', 10, 2, 0, 2, '2014-03-16 16:55:48'),
(5, 'qqq4', '2014-03-17 16:55:48', '2014-03-16 16:55:48', 10, 3, 0, 2, '2014-03-16 16:55:48'),
(6, 'qqq5', '2014-03-17 16:55:48', '2014-03-16 16:55:48', 7, 3, 0, 2, '2014-03-16 16:55:48'),
(7, 'qqq6', '2014-03-18 16:55:48', '2014-03-16 16:55:48', 7, 5, 0, 3, '2014-03-16 16:55:48'),
(8, 'qqq7', '2014-03-18 16:55:48', '2014-03-16 16:55:48', 7, 6, 0, 3, '2014-03-16 16:55:48'),
(9, 'qqq8', '2014-03-18 16:55:48', '2014-03-16 16:55:48', 7, 7, 0, 3, '2014-03-16 16:55:48'),
(10, 'qqq9', '2014-03-16 16:55:48', null, 9, 1, 0, 4, '2014-03-16 16:55:48'),
(11, 'qqq10', '2014-03-16 16:55:48', '2014-03-16 16:55:48', 9, 2, 0, 4, '2014-03-16 16:55:48'),
(12, 'qqq11', '2014-03-17 16:55:48', '2014-03-16 16:55:48', 9, 3, 0, 4, '2014-03-16 16:55:48'),
(13, 'qqq12', '2014-03-17 16:55:48', '2014-03-16 16:55:48', 11, 3, 0, 5, '2014-03-16 16:55:48'),
(14, 'qqq13', '2014-03-16 16:55:48', '2014-03-16 16:55:48', 11, 2, 0, 5, '2014-03-16 16:55:48'),
(15, 'qqq14', '2014-03-16 16:55:48', '2014-03-16 16:55:48', 11, 2, 0, 5, '2014-03-16 16:55:48'),
(16, 'qqq20', '2014-03-18 16:55:48', '2014-03-16 16:55:00', 11, 4, 0, 7, '2014-03-16 16:55:48');

INSERT INTO `JobRequestHistory` (`JobRequestHistoryID`, `OperationDate`, `OfficerID`, `OfficerName`, `JobRequestID`, `StatusID`)
VALUES
(1, '2014-03-16 16:55:48', 7, 'George', 1, 1),
(2, '2014-03-16 16:55:48', 7, 'George', 1, 3),
(3, '2014-03-16 16:55:48', 7, 'George', 2, 1),
(4, '2014-03-16 16:55:48', 7, 'George', 3, 1),
(5, '2014-03-16 16:55:48', 7, 'George', 3, 2),
(6, '2014-03-16 16:55:48', 9, 'George1', 4, 1),
(7, '2014-03-16 16:55:48', 9, 'George1', 4, 2),
(8, '2014-03-16 16:55:48', 9, 'George1', 5, 1),
(9, '2014-03-16 16:55:48', 9, 'George1', 5, 3),
(10, '2014-03-16 16:55:48', 9, 'George1', 6, 1),
(11, '2014-03-16 16:55:48', 9, 'George1', 6, 3),
(12, '2014-03-16 16:55:48', 9, 'George1', 7, 1),
(13, '2014-03-16 16:55:48', 9, 'George1', 7, 2),
(14, '2014-03-16 16:55:48', 9, 'George1', 7, 5),
(15, '2014-03-16 16:55:48', 10, 'George2', 8, 1),
(16, '2014-03-16 16:55:48', 11, 'George3', 8, 2),
(17, '2014-03-16 16:55:48', 11, 'George3', 8, 4),
(18, '2014-03-16 16:55:48', 11, 'George3', 8, 6),
(19, '2014-03-16 16:55:48', 11, 'George3', 9, 1),
(20, '2014-03-16 16:55:48', 11, 'George3', 9, 2),
(21, '2014-03-16 16:55:48', 11, 'George3', 9, 4),
(22, '2014-03-16 16:55:48', 11, 'George3', 9, 7),
(23, '2014-03-16 16:55:48', 11, 'George3', 10, 1),
(24, '2014-03-16 16:55:48', 11, 'George3', 11, 1),
(25, '2014-03-16 16:55:48', 11, 'George3', 11, 2),
(26, '2014-03-16 16:55:48', 11, 'George3', 12, 1),
(27, '2014-03-16 16:55:48', 11, 'George3', 12, 3),
(28, '2014-03-16 16:55:48', 11, 'George3', 13, 1),
(29, '2014-03-16 16:55:48', 11, 'George3', 13, 3),
(30, '2014-03-16 16:55:48', 11, 'George3', 14, 1),
(31, '2014-03-16 16:55:48', 11, 'George3', 14, 2),
(32, '2014-03-16 16:55:48', 11, 'George3', 15, 1),
(33, '2014-03-16 16:55:48', 11, 'George3', 15, 2),
(34, '2014-03-16 16:55:48', 11, 'George3', 16, 1),
(35, '2014-03-16 16:55:48', 11, 'George3', 16, 2),
(36, '2014-03-16 16:55:48', 11, 'George3', 16, 4);

INSERT INTO `System` (`SystemID`, `Name`, `Type`, `LegalPerson`, `RegisterFund`, `RegisterTime`, `TotalPeople`, `Address`, `Telephone`, `Email`)
VALUES
(1, 'company', 'Computer software', 'Legal Person', '一千万美元', '1998-09-07 00:00:00', '10000', 'Shanghai, China', '13888888888', 'contact@company.com');
