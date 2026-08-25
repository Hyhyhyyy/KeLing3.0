# Roadmap

## Preview hardening

- Rotate the exposed Android signing identity before any trusted release.
- Keep Web/server builds and Android debug tests green on every pull request.
- Reduce the documented legacy Web lint warning baseline to zero before 1.0.
- Add server integration tests for authentication, ownership boundaries, and migrations.
- Publish an API contract and remove hard-coded service addresses from all clients.

## Closed pilot

- Test account creation, offline failure, synchronization conflicts, export, and deletion
  with 5–10 users.
- Add automatic database backup/restore verification and a migration rollback rehearsal.
- Define accessibility, crash-free session, and data-loss metrics.

## 1.0 criteria

- Reproducible signed Android and Web/server releases with checksums and release notes.
- No signing keys, environment files, databases, or built APKs in reachable new commits.
- Documented account deletion/export and a tested recovery path.
- Two release cycles completed without data loss or an unresolved critical vulnerability.
