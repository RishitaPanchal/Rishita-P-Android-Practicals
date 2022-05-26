package dependancy.injection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DIModule {
    @Provides
    @Singleton
    fun provideStudentRepo(): StudentRepository = StudentRepositoryData()
}