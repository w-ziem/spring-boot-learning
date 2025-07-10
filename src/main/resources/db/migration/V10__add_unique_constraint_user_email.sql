update users
set email = CONCAT(email, '+dup_', id)
where email in (
    select email from ( select email from users group by email having count(*) > 1) as dup_emails
    );

alter table users
    add constraint users_email_unique UNIQUE (email);