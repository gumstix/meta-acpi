inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# Override SRC_URI in a copy of this recipe to point at a different source
# tree if you do not want to build from Linus' tree.
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git;nocheckout=1"

# Use defconfigs not full .configs
KCONFIG_MODE = "--alldefconfig"

SRC_URI += "file://defconfig"
SRC_URI += "file://patches.scc"

SRC_URI_append_galileo = " file://galileo.cfg"
SRC_URI_append_minnowboard = " file://minnowboard.cfg"

LINUX_VERSION ?= "4.9"

# Modify SRCREV to a different commit hash in a copy of this recipe to
# build a different release of the Linux kernel.
# v4.9-rc4
SRCREV = "bc33b0ca11e3df467777a4fa7639ba488c9d4911"

PV = "${LINUX_VERSION}+git${SRCPV}"

# Override COMPATIBLE_MACHINE to include your machine in a copy of this recipe
# file. Leaving it empty here ensures an early explicit build failure.
COMPATIBLE_MACHINE = "galileo|joule|minnowboard|minnowboard-max"
