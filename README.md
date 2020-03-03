This shows an example of sharing common versions and settings in multiple projects of a gradle
multi-project build.

The `blue` and `red` subprojects share commmon setups in the build script, and also common 
dependencies.

The `green` project is a different kind of project, which isn't even JVM-based.

The first commit shows the three projects configured separately, and thus not sharing anything.

The second commit uses a plugin management block in `settings.gradle.kts` to avoid duplicating
the plugin version numbers.

The third commit uses a platform subproject in order to avoid duplicating version number of dependencies,
and making sure all the JVM subprojects use the same library versions.

The fourth commit uses a plugin in buildSrc that reacts to the other plugins by configuring
their extensions or tasks the same way.
