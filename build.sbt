name := """play-openjpa"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  "com.h2database" % "h2" % "1.4.181",
  "org.apache.openjpa" % "openjpa-all" % "2.3.0"
)

lazy val enhance = taskKey[Unit]("Enhances model classes")

enhance <<= (fullClasspath in Runtime, runner, streams).map({(cp, run, s) =>
  // only files from classpath are needed
  val classpath = cp.files
  // any options that need to be passed to the enhancer
  val options = Seq()
  // returns an option of errormessage
  val result = run.run("org.apache.openjpa.enhance.PCEnhancer", classpath, options, s.log)
  // if case of errormessage, throw an exception
  result.foreach(sys.error)
}) triggeredBy(compile in Compile)
