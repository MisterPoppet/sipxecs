include $(top_srcdir)/config/utility.am
include $(top_srcdir)/config/java.am
include $(srcdir)/common.am

EXTRA_DIST = \
	$(hitachi_SRC) \
	$(hitachi_RESOURCES)

noinst_DATA = javac-hitachi

jardir = @SIPX_JAVADIR@/sipXconfig/plugins
JAR_FILE = sipXhitachi.jar
jar_DATA = $(JAR_FILE)

hitachi_SRC = $(shell cd $(srcdir); find org -type f -name '*.java')
hitachi_RESOURCES = sipxplugin.beans.xml

hitachi_DEPS = \
	$(call JavaDep,@SIPX_JAVADIR@/sipXconfig @SIPX_JAVADIR@/sipXcommons,$(hitachi_PKGS))

$(JAR_FILE) : javac-hitachi $(hitachi_RESOURCES)
	jar cf $@ \
	  $(call JarInclude,$(JAVAROOT),.) \
	  $(call JarInclude,$(srcdir),$(hitachi_RESOURCES))

style_SRC = $(hitachi_SRC)
precommit : style validate-xml

validate-xml : sipxplugin.beans.xml
	xmllint --noout \
	  --schema $(SIPX_DATADIR)/schema/spring-beans-2.0.xsd  \
	$^
