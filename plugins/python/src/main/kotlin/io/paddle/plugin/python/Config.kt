package io.paddle.plugin.python

import java.nio.file.Path
import java.nio.file.Paths

object Config {
    /**
     * A home directory for Paddle. Contains installed package caches and internal virtual environment. Planning to support caching wheels, etc.
     */
    val paddleHome: Path = System.getenv("PADDLE_HOME")?.let { Path.of(it) } ?: Paths.get(System.getProperty("user.home"), ".paddle")

    /**
     * A path to the main packages cache directory.
     * It has the following structure:
     *
     * ```
     *   $PADDLE_HOME/
     *       package_name/
     *           version_1/
     *               ...
     *           version_2/
     *               ...
     *       another_package_name/
     *           version_1/
     *               ...
     * ```
     */
    val cacheDir: Path = paddleHome.resolve("cache")

    /**
     * A path to the internal venv directory.
     *
     * Such a virtual environment is used to install all new packages since python's venv
     * do not support installation of the multiple versions for a single package to the same environment.
     */
    val venvDir: Path = paddleHome.resolve(".venv")
}
