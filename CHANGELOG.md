<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# IntelliPikchr Changelog

## Unreleased

## 0.3.3 - 2023-06-02

### Changed
- Raise minimum IDE version to 2021.3 (from 2020.3)
- Mark plugin compatible with 2023.2
- Regenerate Lexer with JFlex 1.9.1

## 0.3.2 - 2022-11-04

### Changed
- Mark plugin compatible with 2022.3

## 0.3.1

### Changed
- Mark plugin compatible with 2022.2

## 0.3.0

### Added
- Syntax highlighting, customize in _Settings/Preferences \| Editor \| Color Scheme \| Pikchr_
- Highlight matching braces
- Bundled Live Templates, customize/add in _Settings/Preferences \| Editor \| Live Templates_
- Bundled dictionary with Pikchr specific terms

## 0.2.2

### Added
- Automated exception reporting to GitHub

### Changed
- Preview editor: force toolbar on left side to disable non-supported _floating toolbar_ mode

## 0.2.1

### Added
- Open Settings from preview editor toolbar

### Changed
- Plugin marked compatible with 2021.3 EAP
- Settings made searchable

## 0.2.0

### Added
- Split editor with preview pane for `.pikchr` files, using [kroki.io](https://kroki.io) or self-hosted server for rendering
- Adapt preview colors to IDE dark UI mode
- Tune preview with custom CSS
- See _Settings/Preferences \| Languages & Frameworks \| IntelliPikchr_ to customize
- Initial scaffold created from [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)
