<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>build-helper-maven-plugin</artifactId>
    <version>1.4</version>
    <executions>
        <execution>
            <id>test</id>
            <phase>generate-sources</phase>
            <goals>
                <goal>add-source</goal>
            </goals>
            <configuration>
                <sources>
                    <source>${basedir}/target/generated-sources</source>
                </sources>
            </configuration>
        </execution>
    </executions>
</plugin>


export MAVEN_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"

mvn help:describe -Dplugin=archetype

mvn help:describe -Dcmd=package

mvn help:describe -Dplugin=archetype -Ddetail

Shade插件

shade:shade