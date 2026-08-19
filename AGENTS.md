# AGENTS.md

## Project Architecture
This is the Parom Service API application, which serves as a backend for creating PAROM reports.
It replaces existing functionality in the NDelius system.
It is a Spring Boot application written in Kotlin and uses Thymeleaf for server-side rendering of HTML templates which
are then converted into PDF reports.

The application interacts with several services:
- **PAROM Frontend/UI**: This is the frontend application that the user interacts with to create and submit PAROM reports. 
This API project provides the endpoints for the frontend to fetch and submit data, as well as generate the final PDF reports.
- **NDelius Integration Service**: (Also sometimes called parom-and-delius) This service is used to fetch offender details from the NDelius system.
- **NDelius**: This is the national offender management system that holds offender data. A user accesses the PAROM frontend via document links inside NDelius.


## Agent Execution Rules
- After making changes, run the ktlintFormat task to format the code. 
  - You can also run the ktlintCheck task to check for formatting issues.

## Worktree Setup Rules
- Do not commit changes when a task is done, leave that to the user.
- Ensure changes are linted and typechecked at the end of a task. If running the integration tests, be aware that parallel
  agents may also be attempting to run the tests and have their own app server running, or may have made changes to WireMock.
    - It may be best to let the fleet coordinator run the tests after each agent has completed their work.
- Unless specifically asked for, do not create new test files.
