# Contributing

KeLing is a preview monorepo containing Web, server, shared TypeScript, and Android clients.
Start with a focused issue and avoid changing multiple clients unless the API contract
requires it.

## Web and server

```bash
npm ci
npm run check
```

## Android

```bash
cd apps/android
./gradlew testDebugUnitTest assembleDebug
```

On Windows use `gradlew.bat`. Pull requests must not contain `.env` files, databases, APKs,
keystores, user content, or credentials. Use the checked-in example environment files and
synthetic test data.

Changes to authentication, synchronization, deletion, backup, or migrations must describe
their failure and rollback behavior. By participating, you agree to follow
[CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md).
