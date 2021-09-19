# IntelliPikchr

![Build](https://github.com/YannCebron/IntelliPikchr/workflows/Build/badge.svg)
<!--[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)-->
<!--[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)-->

> ⚠️ Plugin is in early development and unreleased

Support [Pikchr](https://pikchr.org/) language in IntelliJ-based IDEs.

_Pikchr (pronounced "picture") is a PIC-like markup language for diagrams in technical documentation._

## Features

- Split editor with preview pane for `.pikchr` files, using [kroki.io](https://kroki.io) for rendering
- Adapt preview colors to IDE dark UI mode

### Plans/Ideas

- Full language support (semantic highlighting, completion, refactoring, ...)
- Previews for diagrams embedded in Markdown code fences

## Installation

- Using IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "
  IntelliPikchr"</kbd> >
  <kbd>Install Plugin</kbd>

- Manually:

  Download the [latest release](https://github.com/YannCebron/IntelliPikchr/releases/latest) and install it manually
  using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>
                             
## License | Code of Conduct | Credits

Licensed under [Apache 2 License](LICENSE)

[Contributor Covenant Code of Conduct](CODE_OF_CONDUCT.md)
                                      
Split editor adapted from IntelliJ IDEA [Markdown plugin](https://github.com/JetBrains/intellij-community/tree/master/plugins/markdown)

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
