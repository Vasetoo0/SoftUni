DELIMITER $$

create
    definer = root@localhost procedure count_of_books(IN firstName varchar(50), IN lastName varchar(50), OUT res int)
BEGIN

   set res = (SELECT count(*) as res FROM books as b
    GROUP BY author_id
    HAVING author_id = (select id FROM authors
                       WHERE concat(first_name,' ',last_name) = concat(firstName,' ',lastName)));

END; $$