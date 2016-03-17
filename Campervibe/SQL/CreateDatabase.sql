DROP TABLE IF EXISTS `depot`;
DROP TABLE IF EXISTS `vehicle`;
DROP TABLE IF EXISTS `booking`;

CREATE TABLE `depot` (
    `id` CHAR(36) NOT NULL,
    #`id` BIGINT NOT NULL,
    `code` CHAR(5) NOT NULL,
    `name` CHAR(20) NOT NULL,
    `address1` CHAR(50) NOT NULL,
    `address2` CHAR(50) NOT NULL,
    `address3` CHAR(50) NOT NULL,
    `address4` CHAR(50) NOT NULL,
    `postCode` CHAR(10) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`)
);

INSERT INTO `depot` (`id`, `code`, `name`, `address1`, `address2`, `address3`, `address4`, `postCode`) VALUES
('DBFD9572-46F4-4DA6-B877-02EC0F6A51CF', 'BLU01', 'Blue Depot', '1 Blue Street', 'Blueville', '', '', 'M11AA'),
('B90DE5AB-3550-4913-B8F6-8E1D526CA934', 'GRN02', 'Green Depot', '2 Green Lane', 'Greenborough', '', '', 'M11AA');

#INSERT INTO `depot` (`id`, `code`, `name`, `address1`, `address2`, `address3`, `address4`, `postCode`) VALUES
#(1, 'BLU01', 'Blue Depot', '1 Blue Street', 'Blueville', '', '', 'M11AA'),
#(2, 'GRN02', 'Green Depot', '2 Green Lane', 'Greenborough', '', '', 'M11AA');


CREATE TABLE `vehicle` (
    `id` CHAR(36) NOT NULL,
    #`id` BIGINT NOT NULL,
    `name` CHAR(20) NOT NULL,
    `registrationNumber` CHAR(20) NOT NULL,
    `make` CHAR(50) NOT NULL,
    `model` CHAR(50) NOT NULL,
    `pricePerDay` NUMERIC(5,2) NOT NULL,
    `homeDepotId` CHAR(36) NOT NULL,
    #`homeDepotId` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`)
);

INSERT INTO `vehicle` (`id`, `name`, `registrationNumber`, `make`, `model`, `pricePerDay`, `homeDepotId`) VALUES
('911762e0-31ba-4c6c-83f8-3f2288904975', 'Andy', 'A11 AAA', 'VW', 'T1', 90, 'DBFD9572-46F4-4DA6-B877-02EC0F6A51CF'),
('a50c62cd-b24a-4d0a-aada-9744fce7022c', 'Betty', 'B11 BBB', 'VW', 'T2', 80, 'DBFD9572-46F4-4DA6-B877-02EC0F6A51CF'),
('6850BF08-14D2-49A0-BC28-9285A69094BC', 'Charles', 'C11 CCC', 'VW', 'T25', 70, 'B90DE5AB-3550-4913-B8F6-8E1D526CA934');

#INSERT INTO `vehicle` (`id`, `name`, `registrationNumber`, `make`, `model`, `pricePerDay`, `homeDepotId`) VALUES
#(1, 'Andy', 'A11 AAA', 'VW', 'T1', 90, 1),
#(2, 'Betty', 'B11 BBB', 'VW', 'T2', 80, 1),
#(3, 'Charles', 'C11 CCC', 'VW', 'T25', 70, 2);


CREATE TABLE `booking` (
    `id` CHAR(36) NOT NULL,
    `bookingNumber` CHAR(50) NOT NULL,
    `startDate` DATETIME NOT NULL,
    `endDate` DATETIME NOT NULL,
    `startMileage` NUMERIC(6,1) NULL,
    `endMileage` NUMERIC(6,1) NULL,
    `vehicleId` CHAR(36) NOT NULL,
    `collectedOn` DATETIME NULL,
    `returnedOn` DATETIME NULL,
    `total` NUMERIC(8,2) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`)
);

SELECT * FROM `depot`;
SELECT * FROM `vehicle`;


