create database order_management_system;
use order_management_system;

create table customer(
    id int  primary key auto_increment ,
    name varchar(30),
    dob date,
    email varchar(25),
    password_hash varchar(255),
    last_login datetime,
    deleted_at datetime,
    deleted_by varchar(20),
    created_at datetime default current_timestamp,
    created_by varchar(20),
    updated_at datetime default current_timestamp,
    updated_by varchar(20)
);

create table c_locations(
    id int primary key auto_increment,
    c_id int,
    door_no int,
    st1 varchar(20),
    st2 varchar(20),
    city varchar(20),
    state varchar(20),
    country varchar(20),
    foreign key(c_id) references customer(id) on update cascade
);

create table c_phone(
    id int primary key auto_increment,
    c_id int,
    phone varchar(12) unique,
    foreign key(c_id) references customer(id) on update cascade   
);

create table customer_audit(
    id bigint primary key auto_increment,
    c_id int,
    old_email varchar(25),
    old_password varchar(255),
    changed_at datetime default current_timestamp,
    changed_by varchar(20)
);

create table category(
    id int primary key auto_increment,
    name varchar(20)
);

create table products(
    id int primary key auto_increment,
    name varchar(20),
    description text,
    category_id int,
    current_price decimal(10,2),
    available boolean,
    created_at datetime default current_timestamp,
    created_by varchar(20),
    updated_at datetime default current_timestamp,
    updated_by varchar(20),
    foreign key(category_id) references category(id )  
);

create table product_price(
    id int primary key auto_increment,
    p_id int,
    price decimal(10,2),
    changed_at datetime default current_timestamp,
    changed_by varchar(20),
    foreign key(p_id) references products(id)
);

create table product_audit(
    id bigint,
    p_id int,
    old_name varchar(20),
    old_category varchar(20),
    changed_at datetime default current_timestamp,
    changed_by varchar(20),
    foreign key(p_id) references products(id)
);

create table status(
    id int primary key auto_increment,
    name varchar(20)
);

create table orders(
    id int primary key auto_increment,
    c_id int,
    date date,
    status_id int,
    created_at datetime default current_timestamp,
    created_by varchar(20),
    updated_at datetime default current_timestamp,
    updated_by varchar(20),
    foreign key(c_id) references customer(id),
    foreign key(status_id) references status(id)
);

create table orders_audit(
    id bigint primary key auto_increment,
    order_id int,
    old_status int,
    changed_at datetime default current_timestamp,
    changed_by varchar(20),
    foreign key(order_id) references orders(id)
);

create table orders_products(
    id  int primary key auto_increment,
    order_id int,
    p_id int,
    price decimal(10,2),
    quantity int check (quantity > 0),
    foreign key(order_id) references orders(id),
    foreign key(p_id) references products(id)
);

create table inventory(
    id int primary key auto_increment,
    p_id int,
    stock int check (stock > 0),
    godown varchar(20),
    created_at datetime default current_timestamp,
    created_by varchar(20),
    updated_at datetime default current_timestamp,
    updated_by varchar(20),
    foreign key(p_id) references products(id)
);

create table inventory_audit(
    id bigint primary key auto_increment,
    i_id int,
    old_stock int check(old_stock>0),
    old_godown varchar(20),
    changed_by varchar(20),
    foreign key(i_id) references inventory(id)
);

DELIMITER $$
CREATE TRIGGER trg_customer_update_audit
BEFORE UPDATE ON customer
FOR EACH ROW
BEGIN
    INSERT INTO customer_audit(
        c_id,
        old_email ,
        old_password,
        changed_by 
    ) VALUES(
        OLD.id,
        OLD.email,
        OLD.password_hash,
        NEW.updated_by
    );
    SET NEW.updated_at= CURRENT_TIMESTAMP;
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER trg_product_update_audit
BEFORE UPDATE ON products
FOR EACH ROW
BEGIN
    INSERT INTO product_audit(
        p_id ,
        old_name ,
        old_category ,
        changed_by 
    ) VALUES(
        OLD.id,
        OLD.name,
        OLD.category_id,
        NEW.updated_by
    );
    SET NEW.updated_at= CURRENT_TIMESTAMP;
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER trg_orders_update_audit
BEFORE UPDATE ON orders
FOR EACH ROW
BEGIN
    INSERT INTO orders_audit(
        order_id ,
        old_status ,
        changed_by 
    ) VALUES(
        OLD.id,
        OLD.status_id,
        NEW.updated_by
    );
    SET NEW.updated_at= CURRENT_TIMESTAMP;
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER trg_inventory_update_audit
BEFORE UPDATE ON inventory
FOR EACH ROW
BEGIN
    INSERT INTO inventory_audit(
        i_id,
        old_stock,
        old_godown,
        changed_by
    ) VALUES(
        OLD.id,
        OLD.stock,
        OLD.godown,
        NEW.updated_by
    );
    SET NEW.updated_at= CURRENT_TIMESTAMP;
END $$
DELIMITER ;

create index idx_customer on customer(email);
create index idx_product_category on products(category_id);
create index idx_product_available on products(available);
create index idx_product_created on products(created_at);
create index idx_orders_date on orders(date);
create index idx_orders_status on orders(status_id);