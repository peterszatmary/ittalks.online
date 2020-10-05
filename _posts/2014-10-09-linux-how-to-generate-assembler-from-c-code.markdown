---
layout: post
title: How to generate assembler from C code
date: 2014-10-09
categories: linux programming 
tags: linux C assembler programming
---

Generating Assembler code from C code can be useful. At least students can learn what
 C code means in lower level assembler code.
 
**gcc (the GNU Compiler Collection)** can do it for you. 

Let the following C code in file hello.c.

### hello.c

```
#include<stdio.h>;
main() {
    printf("Hello World");
}
```


translate with

`gcc -S -o hello.s hello.c`

into hello.s in at&t syntax.

### hello.s
 
```
    .file	"hello.c"
	.section	.rodata
.LC0:
	.string	"Hello World"
	.text
	.globl	main
	.type	main, @function
main:
.LFB0:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	movl	$.LC0, %edi
	movl	$0, %eax
	call	printf
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE0:
	.size	main, .-main
	.ident	"GCC: (Ubuntu 4.8.2-19ubuntu1) 4.8.2"
	.section	.note.GNU-stack,"",@progbits</pre> 
```

You can of course manipulate with syntax. Let us try Intel syntax
 
`gcc -S -masm=intel -o hellointel.s hello.c`

Resulting file hellointel.s in intel syntax looks like this .

### hellointel.s
 
```
    .file	"hello.c"
	.intel_syntax noprefix
	.section	.rodata
.LC0:
	.string	"Hello World"
	.text
	.globl	main
	.type	main, @function
main:
.LFB0:
	.cfi_startproc
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	mov	edi, OFFSET FLAT:.LC0
	mov	eax, 0
	call	printf
	pop	rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE0:
	.size	main, .-main
	.ident	"GCC: (Ubuntu 4.8.2-19ubuntu1) 4.8.2"
	.section	.note.GNU-stack,"",@progbits</pre> 
```