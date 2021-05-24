(module
(import "runtime" "print" (func $print (param i32)))
(memory 2000)
(global $SP (mut i32) (i32.const 0)) ;; start of stack
(global $MP (mut i32) (i32.const 0)) ;; mark pointer
(global $NP (mut i32) (i32.const 131071996)) ;; heap 2000*64*1024-4
(func $reserveStack (param $size i32)
(result i32)
get_global $MP
get_global $SP
set_global $MP
get_global $SP
get_local $size
i32.add
set_global $SP
)
(start $init)
(func $init
i32.const 0
i32.const 0
i32.add
i32.const 3
i32.store
i32.const 4
i32.const 0
i32.add
i32.const 6
i32.store
i32.const 0
i32.const 8
i32.add
i32.const 0
i32.store
i32.const 4
i32.const 0
i32.add
i32.load
call $print
i32.const 4
i32.const 8
i32.add
i32.const 2
i32.store
i32.const 8
i32.const 8
i32.add
i32.const 8
i32.store
block
loop
i32.const 4
i32.const 8
i32.add
i32.load
i32.const 8
i32.const 8
i32.add
i32.load
i32.lt_s
i32.eqz
br_if 1
i32.const 8
i32.const 8
i32.add
i32.load
call $print
i32.const 8
i32.const 8
i32.add
i32.const 8
i32.const 8
i32.add
i32.load
i32.const 4
i32.const 8
i32.add
i32.load
i32.div_s
i32.store
i32.const 0
i32.const 8
i32.add
i32.const 0
i32.const 0
i32.add
i32.load
i32.const 8
i32.const 8
i32.add
i32.load
i32.add
i32.store
i32.const 4
i32.const 8
i32.add
i32.load
i32.const 8
i32.const 8
i32.add
i32.load
i32.eq
if
i32.const 4
i32.const 0
i32.add
i32.const 4
i32.const 0
i32.add
i32.load
i32.const 4
i32.const 8
i32.add
i32.load
i32.mul
i32.store
i32.const 4
i32.const 0
i32.add
i32.load
call $print
i32.const 0
i32.const 20
i32.add
i32.const 0
i32.store
i32.const 4
i32.const 20
i32.add
i32.const 0
i32.store
i32.const 8
i32.const 20
i32.add
i32.const 0
i32.store
block
i32.const 12
i32.const 20
i32.add
i32.const 0
i32.store
loop
i32.const 12
i32.const 20
i32.add
i32.load
i32.const 3
i32.lt_s
i32.eqz
br_if 1
block
i32.const 0
i32.const 36
i32.add
i32.const 5
i32.store
loop
i32.const 0
i32.const 36
i32.add
i32.load
i32.const 0
i32.ge_s
i32.eqz
br_if 1
i32.const 8
i32.const 20
i32.add
i32.const 8
i32.const 20
i32.add
i32.load
i32.const 12
i32.const 20
i32.add
i32.load
i32.const 0
i32.const 36
i32.add
i32.load
i32.mul
i32.add
i32.store
i32.const 0
i32.const 36
i32.add
i32.const 0
i32.const 36
i32.add
i32.load
i32.const 1
i32.sub
i32.store
br 0
end
end
i32.const 12
i32.const 20
i32.add
i32.const 12
i32.const 20
i32.add
i32.load
i32.const 1
i32.add
i32.store
br 0
end
end
i32.const 8
i32.const 20
i32.add
i32.load
call $print
end
i32.const 0
i32.const 8
i32.add
i32.load
call $print
br 0
end
end
)
(export "init" (func $init))
)
