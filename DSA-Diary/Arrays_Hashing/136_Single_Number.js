
// Finding single number in Arrays

// Arrays
var singleNumber = function(nums){
    nums.sort((a, b) => a - b);  // pastikan ini berjalan pada array
    for (let i = 0; i < nums.length - 1; i += 2) {
        if (nums[i] !== nums[i + 1]) return nums[i];
    }
    return nums[nums.length - 1];
};

// === TEST CASES ===
console.log(singleNumber([2, 2, 1]));         // Output: 1
console.log(singleNumber([4, 1, 2, 1, 2]));   // Output: 4
console.log(singleNumber([1]));              // Output: 1

// Hash Tables
var singleNumber1 = function(nums){
    const count = {};
    for(let num of nums){
        count[num] = (count[num] || 0)+1;
    }
    for(let num in count){
        console.log(typeof num);
        if(count[num] === 1) return Number(num);
    }
}

// === TEST CASES ===

console.log(singleNumber1([4, 1, 2, 1, 2, 4, 5]));   // Output: undifined


// XOR method bitwise adding
var singleNumberXOR = function(nums){
    let result = 0;
    for(let num of nums){
        result^=num; //XOR will cancel out pairs
    }
    return result;
};

console.groupCollapsed(singleNumberXOR([4, 1, 2, 1, 2, 4, 5]))