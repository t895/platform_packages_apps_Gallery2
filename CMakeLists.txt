cmake_minimum_required(VERSION 3.22.1)
project("app")
enable_language(ASM_NASM)

add_library(jni_filtershow_filters SHARED
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/gradient.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/saturated.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/exposure.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/edge.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/contrast.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/hue.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/shadows.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/highlight.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/hsv.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/vibrance.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/geometry.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/negative.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/redEyeMath.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/fx.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/wbalance.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/redeye.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/bwfilter.c
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/tinyplanet.cc
        ${CMAKE_CURRENT_SOURCE_DIR}/jni/filters/kmeans.cc
)
target_compile_options(jni_filtershow_filters PRIVATE
        -ffast-math
        -O3
        -funroll-loops
)
target_link_libraries(jni_filtershow_filters PRIVATE
        android
        log
        -ljnigraphics
)

add_library(libjpeg-turbo SHARED
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jaricom.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jcapimin.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jcapistd.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jcarith.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jccoefct.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jccolor.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jcdctmgr.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jchuff.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jcicc.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jcinit.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jcmainct.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jcmarker.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jcmaster.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jcomapi.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jcparam.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jcphuff.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jcprepct.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jcsample.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jctrans.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdapimin.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdapistd.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdarith.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdatadst.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdatasrc.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdcoefct.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdcolor.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jddctmgr.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdhuff.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdicc.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdinput.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdmainct.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdmarker.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdmaster.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdmerge.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdphuff.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdpostct.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdsample.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jdtrans.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jerror.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jfdctflt.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jfdctfst.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jfdctint.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jidctflt.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jidctfst.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jidctint.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jidctred.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jmemmgr.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jmemnobs.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jpeg_nbits_table.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jquant1.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jquant2.c
        ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/jutils.c
)
target_compile_options(libjpeg-turbo PRIVATE
        -DWITH_SIMD
        -DNO_GETENV
        -O3
        -fstrict-aliasing
        -Werror
        -Wno-sign-compare
        -Wno-unused-parameter
)
target_include_directories(libjpeg-turbo
        PUBLIC ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo
)

if (CMAKE_ANDROID_ARCH_ABI STREQUAL "arm64-v8a")
    target_sources(libjpeg-turbo PRIVATE
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/arm/aarch64/jchuff-neon.c
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/arm/aarch64/jsimd.c
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/arm/jccolor-neon.c
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/arm/jcgray-neon.c
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/arm/jcphuff-neon.c
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/arm/jcsample-neon.c
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/arm/jdcolor-neon.c
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/arm/jdmerge-neon.c
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/arm/jdsample-neon.c
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/arm/jfdctfst-neon.c
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/arm/jfdctint-neon.c
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/arm/jidctfst-neon.c
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/arm/jidctint-neon.c
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/arm/jidctred-neon.c
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/arm/jquanti-neon.c
    )
    target_compile_options(libjpeg-turbo PRIVATE
            -DNEON_INTRINSICS
    )
    target_include_directories(libjpeg-turbo PRIVATE
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/arm
    )
elseif (CMAKE_ANDROID_ARCH_ABI STREQUAL "x86_64")
    target_sources(libjpeg-turbo PRIVATE
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jccolor-avx2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jccolor-sse2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jcgray-avx2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jcgray-sse2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jchuff-sse2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jcphuff-sse2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jcsample-avx2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jcsample-sse2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jdcolor-avx2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jdcolor-sse2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jdmerge-avx2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jdmerge-sse2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jdsample-avx2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jdsample-sse2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jfdctflt-sse.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jfdctfst-sse2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jfdctint-avx2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jfdctint-sse2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jidctflt-sse2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jidctfst-sse2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jidctint-avx2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jidctint-sse2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jidctred-sse2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jquantf-sse2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jquanti-avx2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jquanti-sse2.asm
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jsimd.c
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/x86_64/jsimdcpu.asm
    )
    target_compile_options(libjpeg-turbo PRIVATE
            -DPIC
            -D__x86_64__
    )
    target_include_directories(libjpeg-turbo PRIVATE
            ${CMAKE_CURRENT_SOURCE_DIR}/lib/libjpeg-turbo/simd/nasm
    )
endif ()

if (LINUX)
    target_compile_options(libjpeg-turbo PRIVATE -DELF)
elseif (APPLE)
    target_compile_options(libjpeg-turbo PRIVATE -DMACHO)
elseif (WIN32)
    target_compile_options(libjpeg-turbo PRIVATE -DWIN64)
endif ()

add_library(jni_jpegstream SHARED
        ${CMAKE_CURRENT_SOURCE_DIR}/jni_jpegstream/src/inputstream_wrapper.cpp
        ${CMAKE_CURRENT_SOURCE_DIR}/jni_jpegstream/src/jpegstream.cpp
        ${CMAKE_CURRENT_SOURCE_DIR}/jni_jpegstream/src/jerr_hook.cpp
        ${CMAKE_CURRENT_SOURCE_DIR}/jni_jpegstream/src/jpeg_hook.cpp
        ${CMAKE_CURRENT_SOURCE_DIR}/jni_jpegstream/src/jpeg_writer.cpp
        ${CMAKE_CURRENT_SOURCE_DIR}/jni_jpegstream/src/jpeg_reader.cpp
        ${CMAKE_CURRENT_SOURCE_DIR}/jni_jpegstream/src/outputstream_wrapper.cpp
        ${CMAKE_CURRENT_SOURCE_DIR}/jni_jpegstream/src/stream_wrapper.cpp
)
target_compile_options(jni_jpegstream PRIVATE
        -ffast-math
        -O3
        -funroll-loops
        -Wall
        -Wextra
        -Werror
)
target_link_libraries(jni_jpegstream PRIVATE
        android
        log
        libjpeg-turbo
)
