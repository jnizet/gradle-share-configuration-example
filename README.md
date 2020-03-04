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

The fifth commit moves the shared configuration from a plugin in buildSrc to the root project
build script, inside a `subprojects` block. The trick is to declare the plugins in the root 
build script but without applying them, so that the classes of the plugin are available to 
the root build script.
By applying this technique, the plugins versions can be moved back to the settings.gradle.kts 
file as in the second commit.
