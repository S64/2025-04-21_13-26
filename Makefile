.PHONY:
prerequisites:
	test -n "$(EP2BASEDLIB_VERSION)"

.PHONY: publish-to-local
publish-to-local: prerequisites
	./ep2basedlib/gradlew \
        -p ./ep2basedlib/ \
        :ep2basedlib:publishLegacyReleasePublicationToMavenLocal \
        :ep2basedlib:publishStyledReleasePublicationToMavenLocal

.PHONY: build-app
build-app: prerequisites publish-to-local
	./media3app/gradlew \
        -p ./media3app/ \
        :app:assembleLegacyDebug\
        :app:bundleLegacyDebug \
        :app:assembleStyledDebug\
        :app:bundleStyledDebug

.PHONY: build
build: prerequisites publish-to-local build-app

.PHONY: test-app-legacy
test-app-legacy: prerequisites build-app
	./media3app/gradlew \
        -p ./media3app/ \
        :app:connectedLegacyDebugAndroidTest

.PHONY: test-app-styled
test-app-styled: prerequisites build-app
	./media3app/gradlew \
        -p ./media3app/ \
        :app:connectedStyledDebugAndroidTest

.PHONY: test-app
test-app: prerequisites test-app-legacy test-app-styled

.PHONY: test
test: prerequisites test-app
