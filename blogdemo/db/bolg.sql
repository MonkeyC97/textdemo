use blog;
select a.id,a.title,a.content from article a join user u on a.user_id = u.id;