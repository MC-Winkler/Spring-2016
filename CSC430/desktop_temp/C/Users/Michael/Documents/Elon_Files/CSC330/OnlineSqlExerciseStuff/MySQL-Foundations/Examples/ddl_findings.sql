CREATE TABLE IF NOT EXISTS `findings`
     (
       `patient_fk`                INT(11)   NOT NULL   , 
       `finding_type_cde`          CHAR(6)   NOT NULL   , 
       `data_create_timestamp`     CHAR(26)  NOT NULL   , 
       `facility_fk`               INT(11)       NULL   , 
       `service_type_cde`          CHAR(6)       NULL   , 
       `service_create_timestamp`  CHAR(26)      NULL   , 
       `finding_timestamp`         DATETIME      NULL   , 
       `provider_fk`               INT(11)       NULL   , 
       `finding_subtype_cde`       CHAR(6)       NULL   , 
       `medicalconcept_fk`         INT(11)       NULL   , 
       `value`                     CHAR(10)      NULL   , 
       `uom`                       CHAR(10)      NULL   , 
       PRIMARY KEY (patient_fk, finding_type_cde, data_create_timestamp) 
     ) ENGINE = MYISAM
;

CREATE INDEX IX_findings_service_create_timestamp USING BTREE
ON     findings(service_create_timestamp) 
;