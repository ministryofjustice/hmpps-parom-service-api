CREATE TABLE public.parom
(
    id                          uuid PRIMARY KEY,
    crn                         char(7) NOT NULL,
    title_and_full_name         varchar(200),
    date_of_form                date NULL,
    sheet_sent_by               varchar(100)
);