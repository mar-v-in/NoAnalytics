LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)
LOCAL_SRC_FILES := $(call all-java-files-under, NoAnalytics/src)
LOCAL_MODULE := libGoogleAnalyticsV2
LOCAL_MODULE_TAGS := optional
LOCAL_MODULE_CLASS := JAVA_LIBRARIES
LOCAL_MODULE_PATH := $(TARGET_OUT)/fake_packages/libGoogleAnalyticsV2.jar

include $(BUILD_JAVA_LIBRARY)
