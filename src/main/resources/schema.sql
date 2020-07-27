CREATE TABLE tb_item
(
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    content VARCHAR(2048) DEFAULT NULL,
    last_generate DATETIME
) ENGINE=InnoDB,CHARSET=UTF8;
CREATE TABLE tb_config
(
    name VARCHAR(255) PRIMARY KEY NOT NULL,
    value TEXT NOT NULL
)ENGINE=InnoDB,CHARSET=UTF8;
INSERT INTO `tb_config`
VALUES ('template', '<!doctype html>\r\n<html lang=\"zh\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"viewport\"\r\n          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\r\n    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n    <title>item</title>\r\n</head>\r\n<body>\r\n    <div>\r\n        id: ${item.id}\r\n    </div>\r\n    <div>\r\n        title: ${item.title}\r\n    </div>\r\n    <div>\r\n        content: ${item.content}\r\n    </div>\r\n</body>\r\n</html>');