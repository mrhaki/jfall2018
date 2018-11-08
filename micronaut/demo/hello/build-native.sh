#!/bin/bash

java -cp build/libs/hello-0.1-all.jar io.micronaut.graal.reflect.GraalClassLoadingAnalyzer

/Users/mrhaki/.sdkman/candidates/java/1.0.0-rc7-graal/bin/native-image --no-server \
             --class-path build/libs/hello-0.1-all.jar \
             -H:ReflectionConfigurationFiles=build/reflect.json \
             -H:EnableURLProtocols=http \
             -H:IncludeResources="logback.xml|application.yml|META-INF/services/*.*" \
             -H:Name=hello \
             -H:Class=jfall.Application \
             -H:+ReportUnsupportedElementsAtRuntime \
             -H:+AllowVMInspection \
             --rerun-class-initialization-at-runtime='sun.security.jca.JCAUtil$CachedSecureRandomHolder,javax.net.ssl.SSLContext' \
             --delay-class-initialization-to-runtime=io.netty.handler.codec.http.HttpObjectEncoder,io.netty.handler.codec.http.websocketx.WebSocket00FrameEncoder,io.netty.handler.ssl.util.ThreadLocalInsecureRandom

             