CREATE DATABASE IF NOT EXISTS baft;
USE baft;

/*Table structure for table `mapping` */

CREATE TABLE IF NOT EXISTS `mapping` (

  `id` int(11) NOT NULL auto_increment,
  `preferred_name` varchar(500)  NOT NULL default '', 
  `name` varchar(500) NOT NULL default '', 
  `source` varchar(500)  NOT NULL default '',
   PRIMARY KEY  (`id`)
);


/*Table structure for table `weights` */

CREATE TABLE IF NOT EXISTS `weights` (

  `id` int(11) NOT NULL auto_increment,
  `gene_a` varchar(500)  NOT NULL default '', 
  `gene_b` varchar(500)  NOT NULL default '',
  `weight` varchar(500)  NOT NULL default '',
  PRIMARY KEY  (`id`)
);
