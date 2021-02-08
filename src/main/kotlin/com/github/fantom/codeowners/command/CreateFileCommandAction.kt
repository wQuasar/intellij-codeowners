package com.github.fantom.codeowners.command

import com.github.fantom.codeowners.CodeownersFileType
import com.github.fantom.codeowners.CodeownersLanguage
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import com.intellij.util.IncorrectOperationException

/**
 * Command action that creates new file in given directory.
 */
class CreateFileCommandAction(project: Project, val directory: PsiDirectory, val fileType: CodeownersFileType) :
    CommandAction<PsiFile>(project) {

    /**
     * Creates a new file using [CodeownersTemplatesFactory.createFromTemplate] to fill it with content.
     *
     * @return created file
     */
    override fun compute() = createFromTemplate()
//            CodeownersTemplatesFactory(fileType).createFromTemplate(directory)


    /**
     * Creates new CODEOWNERS file or uses an existing one.
     *
     * @param directory working directory
     * @return file
     */
    @Throws(IncorrectOperationException::class)
    private fun createFromTemplate(): PsiFile {
        val filename = CodeownersLanguage.INSTANCE.filename
        directory.findFile(filename)?.let {
            return it
        }

        val content = ""
        val file = PsiFileFactory.getInstance(directory.project).createFileFromText(filename, fileType, content)
        return directory.add(file) as PsiFile
    }
}
