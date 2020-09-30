---
layout: post
title: (Linux) How to generate c code from assembler
date: 2014-10-09
categories: linux programming 
tags: linux C assembler programming
---

Niekedy sa môže hodiť rýchla tvorba Assembler kódu už z existujúceho kódu písaného v jazyku C. 
Minimálne si takto môžu uľahčiť prácu študenti pre svoje zadania v Assembleri alebo sa takto môžu zvedavci učiť.

Reč je o nástroji **gcc (the GNU Compiler Collection)** a o jeho šikovnom prepínači **-S**. 

Majme jednoduchý kód v jazyku C. Súbor nazvime hello.c.

### hello.c

```
#include<stdio.h>;
main() {
    printf("Hello World");
}
```


Nasledujúci príkaz v Linux terminály... 

`gcc -S -o hello.s hello.c`

Vygeneruje súbor hello.s s at&t syntaxou.

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

Nasledujúci príkaz v Linux terminály...
 
`gcc -S -masm=intel -o hellointel.s hello.c`

Vygeneruje súbor hellointel.s s intel syntaxou.

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