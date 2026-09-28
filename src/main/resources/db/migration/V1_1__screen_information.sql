INSERT INTO public.screen_information (id, screen_name, field_name, field_text, created_by_user, created_datetime, last_updated_user, last_updated_datetime)
VALUES
    (gen_random_uuid(), 'mental_health', 'mental_health_concerns',
     'This is about current or previous info that is relevant to the case e.g. a diagnosis that is relevant to risk or might affect engagement with the plan.',
     'SYSTEM', now(), 'SYSTEM', now()
    ),

    (gen_random_uuid(), 'mental_health', 'mental_capacity_concerns',
     'This is about info that could be relevant to a hearing for example, such as whether mental capacity issues impact the prisoner’s ability to engage in a parole review. Remember any neurodiversity concerns.',
     'SYSTEM', now(), 'SYSTEM', now()
    ),

    (gen_random_uuid(), 'prisoner_contact', 'knowledge_of_prisoner',
     'Be concise here and remember, no need to add dates, details such as phone numbers etc. Panels don’t need a detailed chronology of contact and don’t need the date and nature of every contact made.
It’s important that the panel understand what your involvement in the case has been, as well as the nature of the prisoner’s engagement with you. Help the panel understand how well the relationship between the COM and the prisoner has developed. ',
     'SYSTEM', now(), 'SYSTEM', now()
    ),

    (gen_random_uuid(), 'prisoner_contact', 'prisoners_family',
     'Be concise here and remember, no need to add dates, details such as phone numbers etc. Panels don’t need a detailed chronology of contact and don’t need the date and nature of every contact made.
This section helps the panel understand who the key people in the prisoner’s life are and what your knowledge of them is. This section is a basic summary – the panel will be looking at your OASys for more analysis. Make sure that your OASys contains disclosable analysis of the role they play in the prisoner’s life e.g., to what extent are they a protective factor?
Where the prisoner has no family, partner etc or refuses to provide details, you can simply state this with a brief explanation.',
     'SYSTEM', now(), 'SYSTEM', now()
    ),

    (gen_random_uuid(), 'prisoner_contact', 'prisoner_agencies',
     'Be concise here and remember, no need to add dates, details such as phone numbers etc. Panels don’t need a detailed chronology of contact and don’t need the date and nature of every contact made.
By the end of this section, the panel should have a clear understanding of all the people involved in the prisoner’s life. This could include professionals involved with release planning e.g., Approved Premises staff, potential employers or community services.
Where the prisoner is not working with any services it is ok to just state this.
If the report author is not the COM, include here any contact with the COM.',
     'SYSTEM', now(), 'SYSTEM', now()
    ),

    (gen_random_uuid(), 'attitudes', 'attitude_to_index_offences',
     'This is about a rounded analysis - not just description, and not just what the prisoner has said. Consider their current levels of responsibility / culpability. Think about diversity and maturity. Think about issues such as learning challenges. Include here evidence from a wide range of sources e.g., specialist reports.
Remember: the panel have the risk information in the OASys already. Be specific here about attitude, rather than risk issues more generally.
A note here: It is important here to provide this analysis whilst remembering that denial does not necessarily equate to increased risk .',
     'SYSTEM', now(), 'SYSTEM', now()
    ),

    (gen_random_uuid(), 'attitudes', 'attitude_to_previous_offences',
     'This is about a rounded analysis - not just description, and not just what the prisoner has said. Consider their current levels of responsibility / culpability. Think about diversity and maturity. Think about issues such as learning challenges. Include here evidence from a wide range of sources e.g., specialist reports.
Remember: the panel have the risk information in the OASys already. Be specific here about attitude, rather than risk issues more generally.
A note here: It is important here to provide this analysis whilst remembering that denial does not necessarily equate to increased risk .',
     'SYSTEM', now(), 'SYSTEM', now()
    ),

    (gen_random_uuid(), 'opd_and_programmes', 'custodial_behaviour',
     'Here, avoid repeating the detail in the parole custody report and instead, simply analyse it succinctly. Think about patterns of behaviour, reasons for significant changes in behaviour. Be mindful about any gaps in information. Whatever the custodial behaviour, remember to analyse how this translates to the offending behaviour of concern.  ',
     'SYSTEM', now(), 'SYSTEM', now()
    ),

    (gen_random_uuid(), 'opd_and_programmes', 'impact_of_interventions',
     ' How much progress has been made and why? What difference have the interventions made? Think about:
•	Shifts in behaviours/attitudes.
•	Responsivity/diversity considerations such as IQ, learning disabilities, maturity and personality disorder.
•	If they’ve done no programmes in the last 5 years, think about significant interventions completed previously and whether they remain relevant. ',
     'SYSTEM', now(), 'SYSTEM', now()
    ),

    (gen_random_uuid(), 'mappa_and_plans', 'resettlement_plan',
     'The panel with have the Risk Management Plan from the OASys. Instead, here, the focus is on resettlement. It should provide a narrative of how the prisoner will be assisted in resettling into the community.

Here, the panel will want to know:
• where the prisoner will live,
• what they will be doing (e.g. employment, drug treatment) and
• what will be in place to manage risk (but not licence conditions – there is a separate section for these).

Your analysis of the plan is important, (see analytical writing section) including your assessment of the likelihood of compliance with the plan. Where an Approved Premises or other supported accommodation is required, be clear about whether the referral has been accepted and any timelines / assessments involved.

Important issues to consider include:
• whether the person entered custody a juvenile
• whether they were previously a care leaver or have been in secure accommodation
• whether these issues mean that life skills like managing tenancies, budgeting, cooking etc might need developing with the support of additional services
• any diversity needs relating to accommodation',
     'SYSTEM', now(), 'SYSTEM', now()
    ),

    (gen_random_uuid(), 'mappa_and_plans', 'supervision_plan',
     'This is where you set out what work will be done on licence to continue to reduce / manage risk and strengthen protective factors. Include your analysis of likelihood of compliance, any relevant timeframes and any assessments needed. Here, the panel is considering the one-to-one work that the COM and person on licence will do, as well as the work completed by other agencies, and anyone involved in the statutory supervision.

Consider the role of wider professionals here such as:
• Medical professionals
• Social care
• Police
• IOM',
     'SYSTEM', now(), 'SYSTEM', now()
    ),

    (gen_random_uuid(), 'ippdpp', 'ipp_recommendation',
     'This follows the same guidance above in the professional opinions box, but instead is about whether you think the IPP licence ought to be terminated. It’s only for use in eligible cases, but in those cases, you MUST provide a recommendation. Make sure you’re following the IPP guidance on termination and how to assess the issues. ',
     'SYSTEM', now(), 'SYSTEM', now()
    ),

    (gen_random_uuid(), 'member_case_assessment', 'assessment_oral_considerations',
     'This section enables the panel to understand what they need to consider when progressing the case in terms of diversity or security information. Avoid duplication here with the metal health and capacity section earlier in the report. Include anything here that isn’t covered in that section.

Where relevant, this could include:
- Any communication challenges such as difficulties reading and/or writing,
- Reasonable adjustments for diversity reasons including neurodiversity.
- English as a second language, need for an interpreter, or BSL / hearing loop.
- Welsh as a preferred language
- Relevant and disclosable security information which may impact on the prisoner’s ability to engage effectively at the oral hearing.
- Whether the hearing needs to be held face to face
Or any other issues that the panel may need to consider.',
     'SYSTEM', now(), 'SYSTEM', now()
    ),

    (gen_random_uuid(), 'professional_opinions', 'professional_opinion',
     'A good professional opinion should be one to three paragraphs at most. It should include:
- Your straightforward opinion. Remember, you’re the professional. Your view is important.
- Clear and succinct reasons behind your professional opinion which flow logically following the rest of your report and OASys
- How realistic management in open conditions or on release will be both in terms of risk and likely compliance.
- Reference to any information and assessments provided by specialists (including those commissioned by the prisoner’s legal team). It is helpful to reflect and comment upon any differences in the opinions they have provided.

Where outstanding reports are required, say this along with the timeframe, so that should the parole board require an addendum report, this can be made available prior to the oral hearing e.g., an outstanding psychology or post programme report.

Where you are not recommending release, say what needs to happen now for progress to be made.',
     'SYSTEM', now(), 'SYSTEM', now()
    ),

    (gen_random_uuid(), 'conclusion', 'report_assessments_directions',
     'Here, you’re detailing what you’ve used in order to write this report and identifying if there were any gaps. Don’t list sources here that are not disclosable to the prisoner. Any disclosable reports used in the writing of this report should be submitted with this report to the prison for inclusion in the parole dossier where disclosable – seek PPCS advice if you’re not sure.
Where information has been unavailable, state this along with any impact it may have.
This is a good point to check that only disclosable information is in this report. If there is any information that should not be disclosed, you must contact the PPCS immediately to discuss the information and a potential non-disclosure application. Please see the Handling Sensitive Information Policy Framework - GOV.UK (www.gov.uk) for more information.',
     'SYSTEM', now(), 'SYSTEM', now()
    );
