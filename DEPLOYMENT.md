# Lifecat Deployment Notes

## Current Status

- Historical public domains and the original server have been retired.
- This repository aggregates multiple historical implementations; verify the exact module before changing deployment.

## Local Smoke Checks

```bash
docker build --check docker
```

The current legacy Dockerfile still reports an obsolete Tomcat image-platform warning and a deprecated `MAINTAINER` instruction. Select the active Java module and target architecture before modernizing the image.

For Java modules, run Maven from the relevant module directory if the module is available locally:

```bash
mvn test
mvn package
```

For Vue modules, run npm commands from the relevant frontend directory if available:

```bash
npm install
npm run build
```

## Deployment Checklist

- Confirm which implementation is authoritative: Servlet, SSM, Spring Boot + Vue, Android, WeChat Mini Program, Python, Hadoop, or STM32.
- Confirm MySQL schema and seed data before pointing a public host at a new instance.
- Keep credentials outside Git. Use `.env.example` only as a template.
- Provision a new host, DNS record, and certificate before publishing any module again.
- For Docker-based hosting, validate compose configuration before applying changes on the server.

## Follow-Up Optimization

- Split active deployment artifacts from historical reference material if this project becomes active again.
- Add module-specific build/test commands once the active subproject is selected.
