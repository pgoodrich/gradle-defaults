/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mooregreatsoftware.gradle.defaults;


import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Extends {@link Iterable} to add direct {@link Stream} support.
 */
@SuppressWarnings("TypeParameterExplicitlyExtendsObject")
public interface StreamableIterable<T extends @NonNull Object> extends Iterable<T> {

    default Stream<T> stream() {
        return StreamSupport.stream(spliterator(), false);
    }


    @SuppressWarnings("Convert2MethodRef")
    static <T> StreamableIterable<T> of(Iterable<T> iterable) {
        return () -> iterable.iterator();
    }

}
