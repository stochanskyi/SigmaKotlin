package features.annotations.serialization.annotations

@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY)
annotation class FieldName(val name: String)