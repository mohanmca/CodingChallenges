const countCanConstruct = (target, wordBank, memo = {}) => {
    if(target in memo) return memo[target];
    if(target==='') return 1;
    let totalCount = 0;
    for(let word of wordBank) {
        if(target.startsWith(word)) {
            let suffix = target.substring(word.length)
            const numWaysFirRest = countCanConstruct(suffix, wordBank, memo);
            totalCount += numWaysFirRest;
        }
    }
    memo[target] = totalCount;
    return memo[target];
}

console.log(countCanConstruct('abcdef', ['ab', 'abc', 'cd', 'def', 'abcd']))
console.log(countCanConstruct('purple', ['purp', 'p', 'ur', 'le', 'purpl']))
console.log(countCanConstruct('skateabcdefg', ['ab', 'abc', 'cd', 'def', 'abcd','ska','te','bo']))
console.log(countCanConstruct('enterapotentpot', ['a', 'p', 'ent', 'enter', 'ot','o','t']))
console.log(countCanConstruct('eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef', ['e', 'ee', 'eee', 'eeee', 'eeeee','eeeeee','te','bo']))
console.log(countCanConstruct('eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee', ['e', 'ee', 'eee', 'eeee', 'eeeee','eeeeee','te','bo']))
console.log(countCanConstruct('impossible', ['ab', 'abc', 'cd', 'def', 'abcd']))