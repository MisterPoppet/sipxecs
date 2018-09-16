include $(top_srcdir)/config/utility.am
include $(top_srcdir)/config/java.am
include $(srcdir)/common.am

EXTRA_DIST = \
	$(digium_SRC) \
	$(digium_RESOURCES)

noinst_DATA = javac-digium

jardir = @SIPX_JAVADIR@/sipXconfig/plugins
JAR_FILE = sipXdigium.jar
jar_DATA = $(JAR_FILE)

digium_SRC = $(shell cd $(srcdir); find org -type f -name '*.java')
digium_RESOURCES = sipxplugin.beans.xml

digium_DEPS = \
	$(call JavaDep,@SIPX_JAVADIR@/sipXconfig @SIPX_JAVADIR@/sipXcommons,$(digium_PKGS))

$(JAR_FILE) : javac-digium $(digium_RESOURCES)
	jar cf $@ \
	  $(call JarInclude,$(JAVAROOT),.) \
	  $(call JarInclude,$(srcdir),$(digium_RESOURCES))

style_SRC = $(digium_SRC)
precommit : style validate-xml

validate-xml : sipxplugin.beans.xml
	xmllint --noout \
	  --schema $(SIPX_DATADIR)/schema/spring-beans-2.0.xsd  \
	$^
