# Git Commit Guidelines

## Commit Message Format

Follow the Conventional Commits specification:

```
<type>(<scope>): <subject>

[optional body]

[optional footer(s)]
```

## Types

Use these commit types:

- **feat**: New feature or functionality
- **fix**: Bug fix
- **refactor**: Code changes that neither fix bugs nor add features
- **perf**: Performance improvements
- **style**: Code style changes (formatting, missing semicolons, etc.)
- **test**: Adding or updating tests
- **docs**: Documentation changes
- **build**: Changes to build configuration, dependencies, or `pom.xml`
- **ci**: CI/CD pipeline changes
- **chore**: Maintenance tasks, dependency updates
- **revert**: Reverting previous commits

## Scope Guidelines

Use these scopes for Spring WebFlux components:

- **controller**: REST controllers and reactive endpoints
- **handler**: WebFlux handler functions
- **router**: Router function configurations
- **service**: Business logic and service layer (returning Mono/Flux)
- **repository**: R2DBC repositories and data access layer
- **entity**: Domain models and R2DBC entities
- **config**: Configuration classes and properties
- **security**: Authentication and authorization
- **validation**: Input validation and constraints
- **exception**: Error handling and custom exceptions
- **database**: Database schema and R2DBC configurations
- **api**: API documentation and contracts
- **reactive**: General reactive programming patterns and operators

## Subject Rules

1. **Length**: Maximum 50 characters
2. **Tense**: Use imperative mood ("Add" not "Added")
3. **Capitalization**: Don't capitalize first letter
4. **Punctuation**: No period at the end
5. **Content**: What changes, not why or how
6. **File names**: Use backticks to highlight file names (e.g., `UserController.java`)

## Body Guidelines

Include when the change is complex:

- **Why**: Explain the motivation for the change
- **What**: Describe what changed at a high level
- **Technical details**: Mention specific Spring WebFlux/R2DBC components affected
- **Breaking changes**: Highlight any API or behavior changes

**Format**: Each change or detail should start with a bullet point `-`

## Footer Guidelines

Include:

- **BREAKING CHANGE**: For incompatible API changes
- **Closes**: Reference issue numbers
- **Relates-to**: Reference related issues

## Examples

### Simple Feature Addition
```
feat(controller): add user registration endpoint

- Create `UserController.java` with POST /api/users endpoint
- Return Mono<User> for non-blocking response
- Add basic validation for email and password fields
- Return 201 status on successful registration

Closes #123
```

### Bug Fix
```
fix(service): resolve null pointer in user lookup

- Add null check in `UserService.findByEmail()` method
- Return Mono.empty() instead of throwing exception
- Update corresponding unit tests with StepVerifier

Fixes #456
```

### Configuration Change
```
build(config): update Spring Boot to 3.5.6

- Upgrade spring-boot-starter-parent version
- Update R2DBC PostgreSQL driver to latest compatible version
- Verify all tests pass with new dependencies
```

### Database Migration
```
feat(database): add user roles table

- Create `Role` entity with R2DBC annotations
- Configure table relationships in R2DBC
- Add schema initialization script
- Update repository to return Flux<Role>

BREAKING CHANGE: User entity now requires roles relationship
```

### Refactoring
```
refactor(service): extract common validation logic

- Move email validation to `ValidationUtils.java`
- Update `UserService` and `AccountService` to use shared validator
- Remove duplicate validation code across services
```

### Reactive Implementation
```
feat(handler): implement reactive user handler

- Create `UserHandler.java` with functional endpoints
- Use Mono/Flux for non-blocking operations
- Integrate with R2DBC repository layer
- Add error handling with onErrorResume
```

## Anti-patterns to Avoid

- Don't use past tense ("Added" → "add")
- Don't be vague ("Update files" → "update `UserController` to handle validation")
- Don't combine unrelated changes in one commit
- Don't forget to mention affected components
- Don't use generic scopes like "misc" or "other"
- Don't forget bullet points in body ("Added new feature" → "- Add new feature")
- Don't forget backticks for file names in subject ("Update UserController" → "update `UserController`")
- Don't mix blocking and reactive code patterns without explanation

Always wrap file names and class names in backticks (``).