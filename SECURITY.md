# Security Policy

Report vulnerabilities through GitHub private vulnerability reporting. Do not place JWT
secrets, provider keys, signing material, access tokens, or user data in a public issue.

## Supported code

The latest `main` branch is supported while the project is in preview. Versioned support
will begin after the first reproducible signed release.

## Android signing notice

An Android keystore backup was previously tracked in the public repository. It must be
treated as compromised and must not be used to sign any future trusted build. Before a
signed release, generate a new upload/signing key, store it only in protected release
secrets, and document the key-rotation or application-ID migration path. Removing the file
from the current tree does not remove it from existing Git history.

Local `.env` files are ignored. Commit only `.env.example` templates containing safe
placeholders. Production JWT and AI-provider secrets must be injected by the deployment
platform and rotated if they are ever exposed.

## Required credential response

The previously embedded AI-provider key and Android signing passwords must be considered
public. Revoke and replace the provider key before enabling AI, rotate the Android signing
identity before any trusted release, and invalidate existing sessions by deploying a new
random JWT secret of at least 32 bytes. Never place replacements in Git history, Gradle
properties, an APK, screenshots, issues, or workflow logs.
