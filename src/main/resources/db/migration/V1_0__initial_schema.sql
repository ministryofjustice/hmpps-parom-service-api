CREATE TABLE public.parom
(
    id                                    uuid PRIMARY KEY,
    crn                                   char(7) NOT NULL,
    terminated                           boolean,
    terminated_unterminated_date         timestamp with time zone,

    basic_details_saved                  boolean,
    mental_health_saved                  boolean,
    prisoner_contact_saved               boolean,
    attitudes_saved                      boolean,
    victims_saved                        boolean,
    opd_and_programmes_saved             boolean,
    mappa_and_plans_saved                boolean,
    professional_opinions_saved          boolean,
    ippdpp_saved                         boolean,
    member_case_assessment_saved         boolean,
    conclusion_saved                     boolean,
    sign_off_saved                       boolean,

    title_and_full_name                  varchar(200),
    report_date                          timestamp without time zone,
    nomis_number                         varchar(8),
    prison_number                        varchar(8),
    parole_eligibility_date               timestamp without time zone,
    community_offender_manager           varchar(250),
    date_appointed                        timestamp without time zone,
    completing_the_form                  varchar(100),
    "position"                            varchar(100),

    mental_health_concerns               varchar(20000),
    mental_capacity_concerns             varchar(20000),
    opd_pathway                          boolean,

    knowledge_of_prisoner                varchar(20000),
    prisoners_family                     varchar(20000),
    prisoner_agencies                    varchar(20000),

    attitude_to_index_offences           varchar(20000),
    attitude_to_previous_offences        varchar(20000),

    victim_contact_scheme                boolean,
    liaison_officer_contact_date          timestamp without time zone,
    victim_personal_statement            boolean,

    custodial_behaviour                  varchar(20000),
    programmes_interventions             varchar(20000),
    impact_of_interventions              varchar(20000),

    mappa_category                       varchar(100),
    mappa_level                          varchar(100),
    resettlement_plan                    varchar(20000),
    supervision_plan                     varchar(20000),
    proposed_license_conditions          varchar(20000),
    risk_of_absconding                   varchar(20),

    ipp_termination_case                 boolean,
    ipp_recommendation                   varchar(20000),

    report_authors_professional_opinion  varchar(100),
    professional_opinion                 varchar(20000),
    confirm_viewed_report                boolean,
    test_consideration_open_conditions   boolean,

    licence_termination_case             boolean,
    assessment_oral_considerations       varchar(20000),

    previous_convictions                 boolean,
    cps_documents                        boolean,
    sentencers_comments                  boolean,
    parole_case_records                  boolean,
    parole_dossier                       boolean,
    parole_custody_report                boolean,
    other                                 boolean,
    report_assessments_directions        varchar(20000),
    limitations_to_sources_provided       boolean,
    limitations_details                  varchar(20000),
    quality_of_information               boolean,
    oasys_management_plan                boolean,
    parole_board_report                  boolean,

    p_s_region                           varchar(100),
    p_d_u                                varchar(100),
    email_address                        varchar(250),
    contact_telephone_number             varchar(35),

    created_by_user                      varchar(100) NOT NULL,
    created_datetime                     timestamp without time zone NOT NULL,
    last_updated_user                    varchar(100) NOT NULL,
    last_updated_datetime                timestamp without time zone NOT NULL
);

CREATE TABLE public.screen_information
(
    id                     uuid PRIMARY KEY,
    screen_name            varchar(200),
    field_name             varchar(200),
    field_text             varchar(20000),
    created_by_user        varchar(100) NOT NULL,
    created_datetime       timestamp without time zone NOT NULL,
    last_updated_user      varchar(100) NOT NULL,
    last_updated_datetime  timestamp without time zone NOT NULL
);

CREATE TABLE public.programme_intervention
(
    id                       uuid PRIMARY KEY,
    parom_id                 uuid REFERENCES public.parom(id),
    name_of_programme        varchar(300),
    date_completed           timestamp with time zone,
    post_programme_report    boolean,
    created_by_user          varchar(100) NOT NULL,
    created_datetime         timestamp without time zone NOT NULL,
    last_updated_user        varchar(100) NOT NULL,
    last_updated_datetime    timestamp without time zone NOT NULL
);

CREATE TABLE public.signatory
(
    id                     uuid PRIMARY KEY,
    parom_id               uuid REFERENCES public.parom(id),
    forename               varchar(100),
    surname                varchar(100),
    username               varchar(100),
    email_address          varchar(200),
    region                 varchar(100),
    telephone_number       varchar(35),
    signatory_level        varchar(20),
    signed                 boolean,
    signature_date         timestamp with time zone,
    created_by_user        varchar(100) NOT NULL,
    created_datetime       timestamp without time zone NOT NULL,
    last_updated_user      varchar(100) NOT NULL,
    last_updated_datetime  timestamp without time zone NOT NULL
);