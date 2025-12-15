# CI/CD Hub Fixtures

Purpose-built projects to exercise the hub pipelines end-to-end (templates, profiles, workflows). Push this repo as-is and point the hub smoke tests at these fixtures for predictable results.

## Projects

- `java-passing` — Maven project with passing tests, clean lint.
- `java-failing` — Maven project with one failing test.
- `python-passing` — Small package with passing pytest, formatted code.
- `python-failing` — Same but with one failing test.

## How to use with hub

1. Push this repo to GitHub (e.g., `OWNER/ci-cd-hub-fixtures`).
2. In the hub repo, add `config/repos/fixtures-*.yaml` pointing to these projects.
3. Run the hub smoke-test workflow targeting the fixture configs; record run URLs in `audit.md`.

## Contents

```
java-passing/     # Maven, tests pass
java-failing/     # Maven, one failing test
python-passing/   # pytest, tests pass
python-failing/   # pytest, one failing test
```
