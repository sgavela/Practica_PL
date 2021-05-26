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
i32.const 0
i32.const 4
i32.mul
i32.add
i32.const 1
i32.store
i32.const 0
i32.const 0
i32.add
i32.const 1
i32.const 4
i32.mul
i32.add
i32.const 2
i32.store
i32.const 0
i32.const 0
i32.add
i32.const 2
i32.const 4
i32.mul
i32.add
i32.const 3
i32.store
i32.const 0
i32.const 0
i32.add
i32.const 3
i32.const 4
i32.mul
i32.add
i32.const 4
i32.store
i32.const 0
i32.const 0
i32.add
i32.const 4
i32.const 4
i32.mul
i32.add
i32.const 5
i32.store
i32.const 20
i32.const 0
i32.add
i32.const 0
i32.const 4
i32.mul
i32.add
i32.const 10
i32.store
i32.const 20
i32.const 0
i32.add
i32.const 1
i32.const 4
i32.mul
i32.add
i32.const 8
i32.store
i32.const 20
i32.const 0
i32.add
i32.const 2
i32.const 4
i32.mul
i32.add
i32.const 2
i32.store
i32.const 20
i32.const 0
i32.add
i32.const 3
i32.const 4
i32.mul
i32.add
i32.const 12
i32.store
i32.const 20
i32.const 0
i32.add
i32.const 4
i32.const 4
i32.mul
i32.add
i32.const 11
i32.store
i32.const 40
i32.const 0
i32.add
i32.const 1
i32.store
i32.const 0
i32.const 0
i32.add
i32.const 4
i32.const 4
i32.mul
i32.add
i32.load
call $print
i32.const 0
i32.const 0
i32.add
i32.const 1
i32.const 2
i32.add
i32.const 4
i32.mul
i32.add
i32.load
call $print
i32.const 0
i32.const 44
i32.add
i32.const 0
i32.const 4
i32.mul
i32.add
i32.const 20
i32.const 0
i32.add
i32.const 0
i32.const 4
i32.mul
i32.add
i32.load
i32.const 0
i32.const 0
i32.add
i32.const 0
i32.const 4
i32.mul
i32.add
i32.load
i32.add
i32.store
i32.const 0
i32.const 44
i32.add
i32.const 1
i32.const 4
i32.mul
i32.add
i32.const 20
i32.const 0
i32.add
i32.const 1
i32.const 4
i32.mul
i32.add
i32.load
i32.const 0
i32.const 0
i32.add
i32.const 1
i32.const 4
i32.mul
i32.add
i32.load
i32.add
i32.store
i32.const 0
i32.const 44
i32.add
i32.const 2
i32.const 4
i32.mul
i32.add
i32.const 20
i32.const 0
i32.add
i32.const 2
i32.const 4
i32.mul
i32.add
i32.load
i32.const 0
i32.const 0
i32.add
i32.const 2
i32.const 4
i32.mul
i32.add
i32.load
i32.add
i32.store
i32.const 0
i32.const 44
i32.add
i32.const 3
i32.const 4
i32.mul
i32.add
i32.const 20
i32.const 0
i32.add
i32.const 3
i32.const 4
i32.mul
i32.add
i32.load
i32.const 0
i32.const 0
i32.add
i32.const 3
i32.const 4
i32.mul
i32.add
i32.load
i32.add
i32.store
i32.const 0
i32.const 44
i32.add
i32.const 4
i32.const 4
i32.mul
i32.add
i32.const 20
i32.const 0
i32.add
i32.const 4
i32.const 4
i32.mul
i32.add
i32.load
i32.const 0
i32.const 0
i32.add
i32.const 4
i32.const 4
i32.mul
i32.add
i32.load
i32.add
i32.store
i32.const 0
i32.const 44
i32.add
i32.const 0
i32.const 4
i32.mul
i32.add
i32.load
call $print
i32.const 0
i32.const 44
i32.add
i32.const 1
i32.const 4
i32.mul
i32.add
i32.load
call $print
i32.const 0
i32.const 44
i32.add
i32.const 2
i32.const 4
i32.mul
i32.add
i32.load
call $print
i32.const 0
i32.const 44
i32.add
i32.const 3
i32.const 4
i32.mul
i32.add
i32.load
call $print
i32.const 0
i32.const 44
i32.add
i32.const 4
i32.const 4
i32.mul
i32.add
i32.load
call $print
i32.const 40
i32.const 0
i32.add
i32.load
i32.const 0
i32.and
if
i32.const 404
call $print
else
i32.const 505
call $print
end
)
(export "init" (func $init))
)
