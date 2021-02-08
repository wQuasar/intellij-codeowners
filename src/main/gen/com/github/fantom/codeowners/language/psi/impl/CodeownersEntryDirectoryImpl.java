// This is a generated file. Not intended for manual editing.
package com.github.fantom.codeowners.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.fantom.codeowners.language.psi.CodeownersTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.fantom.codeowners.language.psi.*;

public class CodeownersEntryDirectoryImpl extends ASTWrapperPsiElement implements CodeownersEntryDirectory {

  public CodeownersEntryDirectoryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CodeownersVisitor visitor) {
    visitor.visitEntryDirectory(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CodeownersVisitor) accept((CodeownersVisitor)visitor);
    else super.accept(visitor);
  }

}